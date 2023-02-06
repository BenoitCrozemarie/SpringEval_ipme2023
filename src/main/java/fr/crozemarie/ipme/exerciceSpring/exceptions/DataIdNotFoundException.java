package fr.crozemarie.ipme.exerciceSpring.exceptions;

public class DataIdNotFoundException extends RuntimeException{

    public DataIdNotFoundException(Long id){
        super("The Data " + id + " not found");
    }
}
