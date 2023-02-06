package fr.crozemarie.ipme.exerciceSpring.services;

import fr.crozemarie.ipme.exerciceSpring.pojos.Match;
import fr.crozemarie.ipme.exerciceSpring.repositories.MatchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchService extends GeneriqueService<Match> {

    private Logger logger = LoggerFactory.getLogger(MatchService.class);

    private MatchRepository matchRepository;

    @Autowired

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
        setRepo(matchRepository);
    }

    public Match generateScore(Match match) {
        match.getScore().setScoreFinalEquipeA((int) Math.round(Math.random()*10));
        match.getScore().setScoreFinalEquipeB((int) Math.round(Math.random()*10));
        System.out.println(match.getScore());
        match.setScore(match.getScore());
        logger.info("Insert score match : " + match.getId());

        return save(match);
    }
}
