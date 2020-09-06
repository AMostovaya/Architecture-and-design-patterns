package ru.geekbrains.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.geekbrains.repo.RoleRepository;
import ru.geekbrains.service.RoleService;

import java.util.List;

@Controller
public class RoleController {

    private RoleService roleService;
    private final RoleRepository roleRepository;

    @Autowired
    public RoleController(RoleService roleService, RoleRepository roleRepository) {
        this.roleService = roleService;
        this.roleRepository = roleRepository;
    }


    public String roleList(Model model)
    {
        List<Role> rolePage = roleService.findAll();
        model.addAttribute("rolesPage", rolePage);
        return "roles";
    }
}
