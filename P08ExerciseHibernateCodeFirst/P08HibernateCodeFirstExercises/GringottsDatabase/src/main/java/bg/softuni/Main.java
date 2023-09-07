package bg.softuni;

import bg.softuni.entities.Deposit;
import bg.softuni.entities.MagicWand;
import bg.softuni.entities.Wizard;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        MagicWand magicWand = new MagicWand();
        Deposit deposit = new Deposit();

        Wizard wizard = new Wizard();

        entityManager.persist(magicWand);
        entityManager.persist(deposit);
        entityManager.persist(wizard);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}