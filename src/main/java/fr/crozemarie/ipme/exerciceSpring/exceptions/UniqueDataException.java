package fr.crozemarie.ipme.exerciceSpring.exceptions;

public class UniqueDataException extends RuntimeException{
    public UniqueDataException() {
        super("Duplicated Data try to be create ! ");
    }
}
