package fr.crozemarie.ipme.exerciceSpring.controllers;

import fr.crozemarie.ipme.exerciceSpring.pojos.Equipe;
import fr.crozemarie.ipme.exerciceSpring.repositories.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/equipes")
public class EquipeController extends GenericController<Equipe>{
    @Autowired
    private EquipeRepository equipeRepository;

    public EquipeController(){
        super();
    }
}
