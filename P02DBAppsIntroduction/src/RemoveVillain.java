import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *         Write a program that receives an ID of a villain, deletes him from the database
 *         and releases his minions from serving him. As an output print the name of the villain
 *         and the number of minions released. Make sure all operations go as planned,
 *         otherwise do not make any changes to the database. For the output use the format given in the examples.
 *
 *         3     Arabele was deleted
 *               14 minions released
 *         101   No such villain was found
 */
public class RemoveVillain {

    private static final String GET_VILLAIN_BY_ID = "select v.name from villains v where v.id = ?";
    private static final String GET_MINIONS_COUNT_BY_VILLAIN_ID =
            "select count(mv.minion_id) m_count from minions_villains mv where mv.villain_id = ?";
    private static final String DELETE_MINIONS_VILLAIN_BY_VILLAIN_ID =
            "delete from minions_villains as mv where mv.villain_id = ?";
    private static final String DELETE_VILLAIN_BY_VILLAIN_ID =
            "delete from villains as v where v.id = ?";

    private static final String NOT_FOUND_VILLAIN_BY_ID_MESSAGE = "No such villain was found";
    private static final String DELETED_MINIONS_COUNT_BY_VILLAIN_MESSAGE = "%d minions released%n";
    private static final String DELETED_VILLAIN_MESSAGE = "%s was deleted %n";
    private static final String COLUMN_LABEL_OF_MINIONS_COUNT = "m_count";

    public static void main(String[] args) throws SQLException {
        final Connection connection = Util.getSQLConnection();

        final int villainId = new Scanner(System.in).nextInt();

        final PreparedStatement selectedVillain = connection.prepareStatement(GET_VILLAIN_BY_ID);
        selectedVillain.setInt(1, villainId);

        final ResultSet villainSet = selectedVillain.executeQuery();


        if (!villainSet.next()) {
            System.out.println(NOT_FOUND_VILLAIN_BY_ID_MESSAGE);
            return;
        }

        final String villainName = villainSet.getString(Constant.COLUMN_LABEL_NAME);

        final PreparedStatement selectAllMinions = connection.prepareStatement(GET_MINIONS_COUNT_BY_VILLAIN_ID);
        selectAllMinions.setInt(1, villainId);

        final ResultSet countOfMinionsSet = selectAllMinions.executeQuery();
        countOfMinionsSet.next();

        final int countOfDeletedMinions = countOfMinionsSet.getInt(COLUMN_LABEL_OF_MINIONS_COUNT);

        connection.setAutoCommit(false);

        try (
                PreparedStatement deleteMinionsStatement = connection.prepareStatement(DELETE_MINIONS_VILLAIN_BY_VILLAIN_ID);
                PreparedStatement deleteVillainStatement = connection.prepareStatement(DELETE_VILLAIN_BY_VILLAIN_ID)) {

            deleteMinionsStatement.setInt(1, villainId);
            deleteMinionsStatement.executeUpdate();

            deleteVillainStatement.setInt(1, villainId);
            deleteVillainStatement.executeUpdate();

            connection.commit();
            System.out.printf(DELETED_MINIONS_COUNT_BY_VILLAIN_MESSAGE, countOfDeletedMinions);
            System.out.printf(DELETED_VILLAIN_MESSAGE, villainName);
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        }

        connection.close();
    }
}
