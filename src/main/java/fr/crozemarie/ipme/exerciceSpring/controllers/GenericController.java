package fr.crozemarie.ipme.exerciceSpring.controllers;

import fr.crozemarie.ipme.exerciceSpring.exceptions.DataIdNotFoundException;
import fr.crozemarie.ipme.exerciceSpring.pojos.IdentifiablePojo;
import fr.crozemarie.ipme.exerciceSpring.services.GeneriqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@RestController
public abstract class GenericController<T extends  IdentifiablePojo>{

    @Autowired
    private GeneriqueService<T> generiqueService;

    public GenericController() {
    }

    @GetMapping("/")
    public  ResponseEntity<List<T>> getAll(){


//        return ResponseEntity.ok((List<T>) jpaRepository.findAll());
        return ResponseEntity.ok((List<T>) generiqueService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable Long id) throws DataIdNotFoundException {

        return  ResponseEntity.ok(generiqueService.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<T> add(@RequestBody T updated){
        return ResponseEntity.ok(generiqueService.save(updated));
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@RequestBody T updated, @PathVariable Long id){

        return ResponseEntity.ok(generiqueService.update(updated, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        generiqueService.deleteById(id);
        return ResponseEntity.ok("Ok");
    }

}
