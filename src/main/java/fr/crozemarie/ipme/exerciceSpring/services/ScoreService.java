package fr.crozemarie.ipme.exerciceSpring.services;

import fr.crozemarie.ipme.exerciceSpring.pojos.Score;
import fr.crozemarie.ipme.exerciceSpring.repositories.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService extends GeneriqueService<Score>{

    private ScoreRepository scoreRepository;

    @Autowired
    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
        setRepo(scoreRepository);
    }
}
