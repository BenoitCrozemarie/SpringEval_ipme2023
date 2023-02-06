package fr.crozemarie.ipme.exerciceSpring.exceptions;

public class GroupeSizeException extends RuntimeException{
    public GroupeSizeException(Integer id) {
        super("nombre d'equipe dans le groupe incorrect : " + id);
    }
}
