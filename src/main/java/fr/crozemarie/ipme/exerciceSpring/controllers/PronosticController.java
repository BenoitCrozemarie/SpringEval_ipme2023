package fr.crozemarie.ipme.exerciceSpring.controllers;

import fr.crozemarie.ipme.exerciceSpring.pojos.Pronostic;
import fr.crozemarie.ipme.exerciceSpring.pojos.User;
import fr.crozemarie.ipme.exerciceSpring.services.MatchService;
import fr.crozemarie.ipme.exerciceSpring.services.PronosticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pronostics")
public class PronosticController extends GenericController<Pronostic> {

    @Autowired
    private PronosticService pronosticService;
    @Autowired
    private MatchService matchService;
    public PronosticController() {
        super();
    }

    @GetMapping("/match/{id}/win")
    public ResponseEntity<List<Pronostic>> findPronosticWin(@PathVariable Long id){
        return ResponseEntity.ok(pronosticService.findPronoWin(matchService.findById(id)));
    }

    @GetMapping("/match/{id}/lose")
    public ResponseEntity<List<Pronostic>> findPronosticLose(@PathVariable Long id){
        return ResponseEntity.ok(pronosticService.findPronoLose(matchService.findById(id)));
    }

    @GetMapping("/classement")
    public ResponseEntity<Map<User,Integer>> findClassement(){
        return ResponseEntity.ok(pronosticService.getClassement());
    }


}
