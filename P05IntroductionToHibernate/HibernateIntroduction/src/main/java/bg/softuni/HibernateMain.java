package bg.softuni;

import bg.softuni.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateMain {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();

        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

//        Student example = new Student();
//        example.setName("Tosho");
//        session.persist(example);

        //retrieve data by get
        Student fromDB = session.get(Student.class, 1);
        System.out.println(fromDB.getId() + " " + fromDB.getName());

        //retrieve data by query
        List<Student> studentList = session.createQuery("FROM Student ", Student.class).list();
        for (Student student : studentList) {
            System.out.println(student.getId() + " " + student.getName());
        }

        session.getTransaction().commit();
        session.close();


    }
}