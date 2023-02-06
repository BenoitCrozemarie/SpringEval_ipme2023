package fr.crozemarie.ipme.exerciceSpring;

import fr.crozemarie.ipme.exerciceSpring.pojos.Equipe;
import fr.crozemarie.ipme.exerciceSpring.pojos.Groupe;
import fr.crozemarie.ipme.exerciceSpring.repositories.EquipeRepository;
import fr.crozemarie.ipme.exerciceSpring.repositories.GroupeRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ExerciceSpringApplicationTests {
	@Autowired
	private GroupeRepository groupeRepository;
	@Autowired
	private EquipeRepository equipeRepository;



	@Test
	void findGroupByEquipe(){
		Groupe groupe1 = new Groupe();
		Groupe groupe2 = new Groupe();
		Equipe equipe1  = new Equipe("toto");
		Equipe equipe2  = new Equipe("titititi");
		Equipe equipe3  = new Equipe("tutututututut");
		ArrayList equipes = new ArrayList<Equipe>();
		equipes.add(equipe1);
		equipes.add(equipe2);
		equipes.add(equipe3);
		groupe1.setEquipes(equipes);

		groupeRepository.save(groupe1);
		groupeRepository.save(groupe2);


		Equipe equip = equipeRepository.findById(Long.valueOf(1)).get();
		System.out.println(equip);

		Groupe group = groupeRepository.findByEquipes(equip);
		System.out.println(group.getId());
	}

}
