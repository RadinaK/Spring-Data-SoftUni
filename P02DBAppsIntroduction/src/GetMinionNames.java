import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetMinionNames {

    private static final String GET_MINION_NAMES_AND_AGES_BY_VILLAIN_ID =
            "SELECT m.name, m.age" +
                    " FROM  minions AS m" +
                    " JOIN minions_villains AS mv ON m.id = mv.minion_id" +
                    " WHERE mv.villain_id = ?;";
    private static final String GET_VILLAIN_NAME_BY_ID =
            "SELECT v.name" +
                    " FROM  villains AS v" +
                    " WHERE v.id = ?;";

    final static String NO_VILLAIN_FORMAT = "No villain with ID %d exists in the database.";
    final static String VILLAIN_FORMAT = "Villain: %s%n";
    final static String MINION_FORMAT = "%d. %s %d%n";

    public static void main(String[] args) throws SQLException {
        final Connection connection = Util.getSQLConnection();

        final PreparedStatement villainStatement = connection.prepareStatement(GET_VILLAIN_NAME_BY_ID);
        int villainId = new Scanner(System.in).nextInt();
        villainStatement.setInt(1, villainId);
        final ResultSet villainSet = villainStatement.executeQuery();

        if (!villainSet.next()) {
            System.out.printf(NO_VILLAIN_FORMAT, villainId);
            connection.close();
            return;
        }

        String villainName = villainSet.getString(Constant.COLUMN_LABEL_NAME);
        System.out.printf(VILLAIN_FORMAT, villainName);

        final PreparedStatement minionsStatement = connection.prepareStatement(GET_MINION_NAMES_AND_AGES_BY_VILLAIN_ID);
        minionsStatement.setInt(1, villainId);
        final ResultSet minionsSet = minionsStatement.executeQuery();

        for (int index = 1; minionsSet.next(); index++) {
            String minionName = minionsSet.getString(Constant.COLUMN_LABEL_NAME);
            int minionAge = minionsSet.getInt(Constant.COLUMN_LABEL_AGE);
            System.out.printf(MINION_FORMAT, index, minionName, minionAge);
        }

        connection.close();
    }
}
