package fr.crozemarie.ipme.exerciceSpring.controllersAdvice;

import fr.crozemarie.ipme.exerciceSpring.exceptions.DataIdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DataIdNotFoundResponse {
    @ResponseBody
    @ExceptionHandler(DataIdNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String dataIdNotFoundHandler(DataIdNotFoundException e) {
        return e.getMessage();
    }
}
