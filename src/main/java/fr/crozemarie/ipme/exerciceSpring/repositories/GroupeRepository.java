package fr.crozemarie.ipme.exerciceSpring.repositories;

import fr.crozemarie.ipme.exerciceSpring.pojos.Equipe;
import fr.crozemarie.ipme.exerciceSpring.pojos.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupeRepository extends JpaRepository<Groupe, Long> {

    Groupe findByEquipes(Equipe equipe);
}
