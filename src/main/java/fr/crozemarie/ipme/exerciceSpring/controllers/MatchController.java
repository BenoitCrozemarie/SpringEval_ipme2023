package fr.crozemarie.ipme.exerciceSpring.controllers;

import fr.crozemarie.ipme.exerciceSpring.pojos.Match;
import fr.crozemarie.ipme.exerciceSpring.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/matchs")
public class MatchController extends GenericController<Match>{
    @Autowired
    private MatchService matchService;

    public MatchController() {
        super();
    }

    @PutMapping("/{id}/result")
    public ResponseEntity<Match> setMatchResult(@PathVariable Long id){
        return ResponseEntity.ok( matchService.generateScore(matchService.findById(id)));
    }
}
