package ru.geekbrains.repo;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository  {

    Optional<User> findUserByName(String nameUser);

    List<User> findAll();

    void withdraw();

    void deposite();
}
