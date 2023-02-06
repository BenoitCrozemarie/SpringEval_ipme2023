package fr.crozemarie.ipme.exerciceSpring.controllers;

import fr.crozemarie.ipme.exerciceSpring.pojos.Score;
import fr.crozemarie.ipme.exerciceSpring.repositories.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/scores")
public class ScoreController extends GenericController<Score>{
    @Autowired
    private ScoreRepository scoreRepository;

    public ScoreController() {
        super();
    }
}
