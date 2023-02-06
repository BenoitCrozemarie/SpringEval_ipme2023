package fr.crozemarie.ipme.exerciceSpring.repositories;

import fr.crozemarie.ipme.exerciceSpring.pojos.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
//    Score findByScorefinalequipea(int score);
    //ScoreRepository findByScoreFinalEquipeA(int score);
    //ScoreRepository findByScorefinalequipeb(int score);

}
