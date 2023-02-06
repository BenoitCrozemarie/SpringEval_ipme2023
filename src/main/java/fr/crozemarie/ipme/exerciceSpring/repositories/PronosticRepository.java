package fr.crozemarie.ipme.exerciceSpring.repositories;

import fr.crozemarie.ipme.exerciceSpring.pojos.Equipe;
import fr.crozemarie.ipme.exerciceSpring.pojos.Match;
import fr.crozemarie.ipme.exerciceSpring.pojos.Pronostic;
import fr.crozemarie.ipme.exerciceSpring.pojos.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PronosticRepository extends JpaRepository<Pronostic, Long> {

    List<Pronostic> findByMatch(Match match);
    List<Pronostic> findByMatchAndEquipePari(Match match, Equipe equipe);

    List<Pronostic> findByUser(User user);

}
