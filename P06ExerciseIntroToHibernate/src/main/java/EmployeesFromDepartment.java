import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeesFromDepartment {

    private final static String PERSISTENCE_NAME = "PU_Name_soft_uni_db";
    private final static String PRINT_FORMAT = "%s %s from %s - $%.2f%n";

    public static void main(String[] args) {
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        String departmentName = "Research and Development";

        entityManager.createQuery("SELECT e FROM Employee e " +
                        "WHERE e.department.name = :dn " +
                        "ORDER BY e.salary ASC, e.id", Employee.class)
                .setParameter("dn", departmentName)
                .getResultList()
                .forEach(e -> System.out.printf(PRINT_FORMAT,
                        e.getFirstName(),
                        e.getLastName(),
                        e.getDepartment().getName(),
                        e.getSalary()));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
