package ru.geekbrains.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.geekbrains.mapper.RoleMapper;
import ru.geekbrains.mapper.UserMapper;
import ru.geekbrains.model.User;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
public class UserController {

    private final UserMapper userMapper;
    private final RoleMapper roleMapper;

    @Autowired
    public UserController(UserMapper userMapper, RoleMapper roleMapper) {
        this.userMapper = userMapper;
        this.roleMapper = roleMapper;
    }

    @GetMapping
    public String userList(Model model) throws SQLException {
        model.addAttribute("users", userMapper.findAll());
        return "users";
    }

    @GetMapping("new")
    public String createUser(Model model) throws SQLException {
         model.addAttribute("user", new User());
         model.addAttribute("roles", roleMapper.findAll());
         return "user";
    }


    @GetMapping("edit")
    public String createUser(@RequestParam("id") Long id, Model model) throws SQLException {

         model.addAttribute("user", userMapper.findById(id));
         model.addAttribute("roles", roleMapper.findAll());
         return "user";
    }

    @DeleteMapping
    public String delete(@RequestParam("id") long id) {
        userMapper.delete(id);
        return "redirect:/user";
    }

}
