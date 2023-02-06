package fr.crozemarie.ipme.exerciceSpring.repositories;

import fr.crozemarie.ipme.exerciceSpring.pojos.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
}
