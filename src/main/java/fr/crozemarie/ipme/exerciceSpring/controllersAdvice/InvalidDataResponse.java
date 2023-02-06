package fr.crozemarie.ipme.exerciceSpring.controllersAdvice;

import fr.crozemarie.ipme.exerciceSpring.exceptions.DataIdNotFoundException;
import fr.crozemarie.ipme.exerciceSpring.exceptions.GroupeSizeException;
import fr.crozemarie.ipme.exerciceSpring.exceptions.RoleNotDefinedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class InvalidDataResponse {

    @ResponseBody
    @ExceptionHandler(GroupeSizeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String GroupeSizeHandler(GroupeSizeException e) {
        return e.getMessage();
    }


    @ResponseBody
    @ExceptionHandler(RoleNotDefinedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String RoleNotDefinedHandler(RoleNotDefinedException e) {
        return e.getMessage();
    }
}
