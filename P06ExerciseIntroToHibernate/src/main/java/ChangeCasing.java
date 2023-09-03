import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ChangeCasing {

    private final static String PERSISTENCE_NAME = "PU_Name_soft_uni_db";
    private final static String UPDATE_ALL_TOWNS_NAME_WITH_LENGTH_LESS_THAN_5 =
            "UPDATE Town t SET t.name = UPPER(t.name) WHERE LENGTH(t.name) <= 5";

    public static void main(String[] args) {
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        //first way
//        entityManager.createQuery(UPDATE_ALL_TOWNS_NAME_WITH_LENGTH_LESS_THAN_5).executeUpdate();

        //second way
        final Query townsQuery = entityManager.createQuery("SELECT t FROM Town t", Town.class);
        final List<Town> townsQueryResultList = townsQuery.getResultList();

        for (Town town : townsQueryResultList) {
            final String townName = town.getName();

            if (townName.length() <= 5) {
                town.setName(townName.toUpperCase());

                entityManager.persist(town);
            }
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
