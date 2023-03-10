package fr.crozemarie.ipme.exerciceSpring.services;

import fr.crozemarie.ipme.exerciceSpring.exceptions.DataIdNotFoundException;
import fr.crozemarie.ipme.exerciceSpring.pojos.IdentifiablePojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class GeneriqueService <T extends IdentifiablePojo> {
    private Logger logger = LoggerFactory.getLogger(GeneriqueService.class);
    protected JpaRepository<T,Long> jpaRepository;

    protected void setRepo(JpaRepository<T,Long> jpaRepository){
        this.jpaRepository = jpaRepository;
    }

    public GeneriqueService(){}
    public List<T> findAll() {
        return (List<T>) jpaRepository.findAll();
    }

    public T findById(Long id) {
        if(!jpaRepository.findById(id).isPresent()){
            logger.warn("Trying to retrieve a non existing id");
            throw new DataIdNotFoundException(id);
        }
        return  ((T) jpaRepository.findById(id).get());
    }


    public T save(T updated) {
        return jpaRepository.save(updated);
    }

    public T update(T updated, Long id) {
        System.out.println(updated);
        if(!updated.getId().equals(id)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Confusing Request ID");
        }
        if(!jpaRepository.findById(updated.getId()).isPresent()){
            throw new DataIdNotFoundException(id);
        }

        return jpaRepository.save(updated);
    }

    public T update(T updated) {

        return jpaRepository.save(updated);
    }

    public void deleteById(Long id){
        jpaRepository.deleteById(id);
    }
}
