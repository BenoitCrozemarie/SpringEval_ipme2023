package fr.crozemarie.ipme.exerciceSpring.repositories;

import fr.crozemarie.ipme.exerciceSpring.pojos.Equipe;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {
    Equipe findByName(String name);
    List<Equipe> findAllByName(String name);

}
