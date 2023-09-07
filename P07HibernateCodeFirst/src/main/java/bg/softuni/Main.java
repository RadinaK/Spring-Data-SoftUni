package bg.softuni;

import bg.softuni.hasEntities.Article;
import bg.softuni.hasEntities.CarRelation;
import bg.softuni.hasEntities.PlateNumber;
import bg.softuni.hasEntities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("relations");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

//        Vehicle car = new Car("Toyota1", "Diesel1", 4);
//        Vehicle plane = new Plane("Rising1", "Petrol1", 205);
//        Vehicle bike = new Bike();
//
//        entityManager.persist(car);
//        entityManager.persist(plane);
//        entityManager.persist(bike);
//
//        Car fromDb = entityManager.find(Car.class, 1);
//        System.out.println(fromDb.getFuelType() + " " + fromDb.getModel());

//        PlateNumber plateNumber = new PlateNumber("PB1205");
//        CarRelation car1 = new CarRelation(plateNumber);
//        CarRelation car2 = new CarRelation(plateNumber);
//
//        entityManager.persist(plateNumber);
//        entityManager.persist(car1);
//        entityManager.persist(car2);

        Article article = new Article("alabala");
        User author = new User("Toshko");

        author.addArticle(article);
        article.setAuthor(author);

        entityManager.persist(author);

        User user = entityManager.find(User.class, 2);

        System.out.println();

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
