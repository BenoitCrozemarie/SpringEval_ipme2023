package fr.crozemarie.ipme.exerciceSpring.services;

import fr.crozemarie.ipme.exerciceSpring.pojos.Equipe;
import fr.crozemarie.ipme.exerciceSpring.repositories.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipeService extends GeneriqueService<Equipe>{

    private EquipeRepository equipeRepository;

    @Autowired
    public EquipeService(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
        setRepo(equipeRepository);
    }
}
