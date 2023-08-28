import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *         Write a program that changes all town names to uppercase for a given country.
 *         Print the number of towns that were changed in the format provided in examples.
 *         On the next line print the names that were changed, separated by coma and a space
 *
 *         Bulgaria 3 town names were affected.
 *         [SOFIA, PLOVDIV, BURGAS]
 *
 *         Italy No town names were affected.
*/
public class ChangeTownNamesCasing {

    private static final String UPDATE_TOWN_NAME = "update towns t set name = upper(name) where t.country = ?;";
    private final static String GET_ALL_TOWN_NAMES_BY_COUNTRY_NAME = "select t.name from towns t where t.country = ?;";

    private final static String NO_TOWNS_AFFECTED_MESSAGE = "No town names were affected.";
    private final static String COUNT_OF_AFFECTED_TOWNS_FORMAT = "%d No town names were affected.%n";

    public static void main(String[] args) throws SQLException {
        final Connection connection = Util.getSQLConnection();

        final String townName = new Scanner(System.in).nextLine();

        final PreparedStatement statement = connection.prepareStatement(UPDATE_TOWN_NAME);
        statement.setString(1, townName);

        final int updatedCount = statement.executeUpdate();

        if (updatedCount == 0) {
            System.out.println(NO_TOWNS_AFFECTED_MESSAGE);
            return;
        }

        System.out.printf(COUNT_OF_AFFECTED_TOWNS_FORMAT, updatedCount);

        PreparedStatement selectAllTowns = connection.prepareStatement(GET_ALL_TOWN_NAMES_BY_COUNTRY_NAME);
        selectAllTowns.setString(1, townName);

        ResultSet allTownsResult = selectAllTowns.executeQuery();

        ArrayList<String> towns = new ArrayList<>();

        while (allTownsResult.next()) {
            towns.add(allTownsResult.getString(Constant.COLUMN_LABEL_NAME));
        }

        System.out.println(towns);

    }

}
