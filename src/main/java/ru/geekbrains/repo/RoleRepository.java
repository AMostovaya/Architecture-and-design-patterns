package ru.geekbrains.repo;

import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository  <Role, Long> {
    List<Role> findAll();
}
