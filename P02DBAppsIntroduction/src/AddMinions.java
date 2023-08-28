import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AddMinions {

    private static final String GET_TOWN_BY_NAME = "SELECT t.id FROM towns t WHERE t.name=?;";
    private static final String INSERT_INTO_TOWNS = "insert into towns(name) values(?);";
    private static final String TOWN_ADDED_FORMAT = "Town %s was added to the database.%n";
    private static final String COLUMN_LABEL_ID = "id";

    private static final String GET_VILLAIN_BY_NAME = "SELECT v.id FROM villains v WHERE v.name=?;";
    private static final String INSERT_VILLAIN = "insert into villains(name, evilness_factor) values(?, ?);";
    private static final String VILLAIN_ADDED_FORMAT = "Villain %s was added to the database.%n";
    private static final String EVILNESS_FACTOR = "evil";

    private static final String INSERT_INTO_MINIONS_VILLAINS =
            "insert into minions_villains(minion_id, villain_id) values(?, ?);";
    private static final String RESULT_FORMAT = "Successfully added %s to be minion of %s%n";


    private static final String INSERT_INTO_MINIONS = "insert into minions(name, age, town_id) values(?, ?, ?);";
    private static final String GET_LAST_MINION = "select m.id from minions m order by m.id desc limit 1;";

    public static void main(String[] args) throws SQLException {
        Connection sqlConnection = Util.getSQLConnection();

        final Scanner scanner = new Scanner(System.in);

        final String[] minionInfo = scanner.nextLine().split(" ");

        final String minionName = minionInfo[1];
        final int minionAge = Integer.parseInt(minionInfo[2]);
        final String minionTown = minionInfo[3];

        final String villainName = scanner.nextLine().split(" ")[1];



        final int townId = getId(sqlConnection,
                List.of(minionTown),
                GET_TOWN_BY_NAME,
                INSERT_INTO_TOWNS,
                TOWN_ADDED_FORMAT);

        final int villainId = getId(sqlConnection,
                List.of(villainName, EVILNESS_FACTOR),
                GET_VILLAIN_BY_NAME,
                INSERT_VILLAIN,
                VILLAIN_ADDED_FORMAT);

        final PreparedStatement insertMinionStatement = sqlConnection.prepareStatement(INSERT_INTO_MINIONS);
        insertMinionStatement.setString(1, minionName);
        insertMinionStatement.setInt(2, minionAge);
        insertMinionStatement.setInt(3, townId);

        insertMinionStatement.executeUpdate();

        final PreparedStatement getLastMinionStatement = sqlConnection.prepareStatement(GET_LAST_MINION);
        final ResultSet lastMinionResultSet = getLastMinionStatement.executeQuery();
        lastMinionResultSet.next();
        final int lastMinionId = lastMinionResultSet.getInt(COLUMN_LABEL_ID);

        final PreparedStatement insertMinionsVillainsStatement = sqlConnection.prepareStatement(INSERT_INTO_MINIONS_VILLAINS);
        insertMinionsVillainsStatement.setInt(1, lastMinionId);
        insertMinionsVillainsStatement.setInt(2, villainId);

        insertMinionsVillainsStatement.executeUpdate();

        System.out.printf(RESULT_FORMAT, minionName, villainName);

        sqlConnection.close();
    }

    private static int getId(Connection sqlConnection,
                             List<String> arguments,
                             String selectQuery,
                             String insertQuery,
                             String printFormat) throws SQLException {
        final String name = arguments.get(0);

        final PreparedStatement selectStatement = sqlConnection.prepareStatement(selectQuery);
        selectStatement.setString(1, name);

        final ResultSet resultSet = selectStatement.executeQuery();

        if (!resultSet.next()) {
            PreparedStatement insertStatement = sqlConnection.prepareStatement(insertQuery);
            for (int index = 1; index <= arguments.size(); index++) {
                insertStatement.setString(index, arguments.get(index-1));
            }

            insertStatement.executeUpdate();

            final ResultSet newResultSet = selectStatement.executeQuery();
            newResultSet.next();

            System.out.printf(printFormat, name);

            return newResultSet.getInt(COLUMN_LABEL_ID);
        }

        return resultSet.getInt(COLUMN_LABEL_ID);
    }
}