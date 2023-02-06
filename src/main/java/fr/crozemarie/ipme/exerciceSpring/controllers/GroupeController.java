package fr.crozemarie.ipme.exerciceSpring.controllers;

import fr.crozemarie.ipme.exerciceSpring.pojos.Groupe;
import fr.crozemarie.ipme.exerciceSpring.services.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groupes")
public class GroupeController extends GenericController<Groupe>{

    @Autowired
    private GroupeService groupeService;

    public GroupeController(){
        super();
    }

    @PutMapping("/{id}/results")
    public ResponseEntity<Groupe> generateScoreMatchGroup(@PathVariable Long id){
        return ResponseEntity.ok( groupeService.generateGroupesScores(id));
    }
}
