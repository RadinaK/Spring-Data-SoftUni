import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class AddingANewAddressAndUpdatingEmployee {

    private final static String PERSISTENCE_NAME = "PU_Name_soft_uni_db";

    public static void main(String[] args) {
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        final String lastName = new Scanner(System.in).nextLine();

        Address newAddress = new Address();
        newAddress.setText("Vitoshka 15");
        entityManager.persist(newAddress);

        int count = entityManager.createQuery("UPDATE Employee e SET e.address = :newAddress WHERE e.lastName = :lastName")
                .setParameter("newAddress", newAddress)
                .setParameter("lastName", lastName)
                .executeUpdate();

        if (count == 0) {
            entityManager.getTransaction().rollback();
        } else {
            entityManager.getTransaction().commit();
        }

        entityManager.close();

        System.out.println(count);
    }
}
