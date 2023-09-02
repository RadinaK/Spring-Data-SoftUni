package bg.softuni;

import bg.softuni.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAMain {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("school-db");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Student student = new Student("Teo");
        em.persist(student);

        Student found = em.find(Student.class, 1);
        System.out.println(found.getId() + " " + found.getName());

//        em.detach(found);
        em.remove(found);

        em.getTransaction().commit();

        em.close();

    }
}
