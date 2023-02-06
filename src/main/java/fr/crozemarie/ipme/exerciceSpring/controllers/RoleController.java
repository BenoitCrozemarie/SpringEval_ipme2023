package fr.crozemarie.ipme.exerciceSpring.controllers;

import fr.crozemarie.ipme.exerciceSpring.pojos.Role;
import fr.crozemarie.ipme.exerciceSpring.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
public class RoleController extends GenericController<Role>{
    @Autowired
    private RoleService roleService;

    public RoleController(){

    }
}
