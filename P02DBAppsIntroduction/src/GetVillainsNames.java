import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class GetVillainsNames {

    private static final String GET_VILLAINS_NAMES =
            "SELECT v.name, COUNT(DISTINCT mv.minion_id) AS minions_count" +
            " FROM villains AS v" +
            " JOIN minions_villains AS mv ON v.id = mv.villain_id" +
            " GROUP BY mv.villain_id" +
            " HAVING minions_count > ?" +
            " ORDER BY minions_count;";
    final static String COLUMN_LABEL_MINIONS_COUNT = "minions_count";
    final static String PRINT_FORMAT = "%s %d";

    public static void main(String[] args) throws SQLException {
       final Connection connection = Util.getSQLConnection();

        final PreparedStatement query = connection.prepareStatement(GET_VILLAINS_NAMES);

        query.setInt(1, 15);

        final ResultSet resultSet = query.executeQuery();

        while (resultSet.next()) {
            final String villainName = resultSet.getString(Constant.COLUMN_LABEL_NAME);
            final int minionsCount = resultSet.getInt(COLUMN_LABEL_MINIONS_COUNT);

            System.out.printf(PRINT_FORMAT, villainName, minionsCount);
        }

        connection.close();
    }
}
