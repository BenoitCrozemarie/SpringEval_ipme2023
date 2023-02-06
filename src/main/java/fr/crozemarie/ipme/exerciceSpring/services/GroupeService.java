package fr.crozemarie.ipme.exerciceSpring.services;

import fr.crozemarie.ipme.exerciceSpring.exceptions.GroupeSizeException;
import fr.crozemarie.ipme.exerciceSpring.pojos.Groupe;
import fr.crozemarie.ipme.exerciceSpring.pojos.Match;
import fr.crozemarie.ipme.exerciceSpring.pojos.Score;
import fr.crozemarie.ipme.exerciceSpring.repositories.GroupeRepository;
import fr.crozemarie.ipme.exerciceSpring.repositories.ScoreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupeService extends GeneriqueService<Groupe>{
    private Logger logger = LoggerFactory.getLogger(GroupeService.class);
    private GroupeRepository groupeRepository;
    private final ScoreRepository scoreRepository;

    private final MatchService matchService;

    @Autowired
    public GroupeService(GroupeRepository groupeRepository,
                         ScoreRepository scoreRepository,
                         MatchService matchService) {
        this.groupeRepository = groupeRepository;
        setRepo(groupeRepository);
        this.scoreRepository = scoreRepository;
        this.matchService = matchService;
    }

    @Override
    public Groupe save(Groupe updated) {
        if(updated.getEquipes().size() != 4){
            logger.warn("Trying to insert a wrong group equip size");
            throw new GroupeSizeException(updated.getEquipes().size());
        }
        generateMatch(updated);
        return jpaRepository.save(updated);
    }

    private void generateMatch(Groupe updated) {
        List<Match> matches = new ArrayList<Match>();
        for (int i = 0; i < updated.getEquipes().size() - 1; i++) {
            for (int j = i+1; j < updated.getEquipes().size(); j++) {
                matches.add(new Match(updated.getEquipes().get(i), updated.getEquipes().get(j), new Score()));
            }
        }
        updated.setMatchs(matches);
    }

    public Groupe generateGroupesScores(Long id) {
        Groupe group = findById(id);

        group.getMatchs().forEach( match -> {
            if(match.getScore().getScoreFinalEquipeA() == -1){
                 matchService.generateScore(match);
            }
        });
        return update(group);
    }

}
