package bg.softuni.springdatademo.services;


import bg.softuni.springdatademo.models.User;

public interface UserService {
    void register(String username, int age);

    User findByUsername(String username);
}
