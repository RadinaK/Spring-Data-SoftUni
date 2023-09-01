package bg.softuni;

import bg.softuni.entities.Account;
import bg.softuni.entities.User;
import bg.softuni.orm.EntityManager;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException,
            IllegalAccessException {
        final EntityManager<User> userEntityManager = new EntityManager<>();
        final EntityManager<Account> accountEntityManager = new EntityManager<>();

        final User deleteTest = User.builder()
                .id(1)
                .username("Nikolay Markov")
                .age(51)
                .build();

//        accountEntityManager.doCreate(Account.class);
//        accountEntityManager.doAlter(Account.class);
        userEntityManager.doDelete(deleteTest);

        System.out.println();

    }
}
