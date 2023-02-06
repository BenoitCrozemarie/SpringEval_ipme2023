package fr.crozemarie.ipme.exerciceSpring.services;

import fr.crozemarie.ipme.exerciceSpring.pojos.Match;
import fr.crozemarie.ipme.exerciceSpring.pojos.Pronostic;
import fr.crozemarie.ipme.exerciceSpring.pojos.Score;
import fr.crozemarie.ipme.exerciceSpring.pojos.User;
import fr.crozemarie.ipme.exerciceSpring.repositories.PronosticRepository;
import fr.crozemarie.ipme.exerciceSpring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PronosticService extends GeneriqueService<Pronostic>{

    private PronosticRepository pronosticRepository;
    private final UserRepository userRepository;

    @Autowired
    public PronosticService(PronosticRepository pronosticRepository,
                            UserRepository userRepository) {
        this.pronosticRepository = pronosticRepository;
        setRepo(pronosticRepository);
        this.userRepository = userRepository;
    }

    public Map<User,Integer> getClassement(){
        List<User> users = userRepository.findAll();
        Map<User,Integer> userClassement = new HashMap<>();
        for (User user:
             users) {
            userClassement.put(user,countWinProno(user));
        }
        return userClassement;
    }

    public int countWinProno(User user){
        List<Pronostic> pronos = pronosticRepository.findByUser(user);
        int res = 0;
        for (Pronostic pronostic:
             pronos) {
            int scoreA = pronostic.getMatch().getScore().getScoreFinalEquipeA();
            int scoreB = pronostic.getMatch().getScore().getScoreFinalEquipeB();

            if(scoreA > scoreB){
                if (pronostic.getMatch().getEquipeA().equals(pronostic.getEquipePari())){
                    res++;
                }
            } else if(scoreA < scoreB){
                if (pronostic.getMatch().getEquipeB().equals(pronostic.getEquipePari())){
                    res++;
                }
            } else {
                if (pronostic.getEquipePari() == null){
                    res++;
                }
            }
        }
        return res;
    }

    public List<Pronostic> findPronoWin(Match match){
        int scoreA = match.getScore().getScoreFinalEquipeA();
        int scoreB = match.getScore().getScoreFinalEquipeB();

        if(scoreA > scoreB){
            return pronosticRepository.findByMatchAndEquipePari(match, match.getEquipeA());
        } else if(scoreA < scoreB){
            return pronosticRepository.findByMatchAndEquipePari(match, match.getEquipeB());
        } else {
            return pronosticRepository.findByMatchAndEquipePari(match, null);
        }

    }

    public List<Pronostic> findPronoLose(Match match) {
        List<Pronostic> pronos = pronosticRepository.findByMatch(match);
        List<Pronostic> pronosWin = findPronoWin(match);

        pronos.removeAll(pronosWin);

        return pronos;
    }
}
