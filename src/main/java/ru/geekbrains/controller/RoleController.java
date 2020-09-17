package ru.geekbrains.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.geekbrains.mapper.RoleMapper;
import ru.geekbrains.model.Role;


import java.sql.SQLException;
import java.util.List;

@Controller
public class RoleController {

    private final RoleMapper roleMapper;

    @Autowired
    public RoleController(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    public String roleList(Model model) throws SQLException {
        List<Role> rolePage = roleMapper.findAll();
        model.addAttribute("rolesPage", rolePage);
        return "roles";
    }
}
