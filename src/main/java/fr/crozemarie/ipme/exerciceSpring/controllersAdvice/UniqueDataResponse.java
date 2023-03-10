package fr.crozemarie.ipme.exerciceSpring.controllersAdvice;

import fr.crozemarie.ipme.exerciceSpring.exceptions.DataIdNotFoundException;
import fr.crozemarie.ipme.exerciceSpring.exceptions.GroupeSizeException;
import fr.crozemarie.ipme.exerciceSpring.exceptions.UniqueDataException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UniqueDataResponse {
    @ResponseBody
    @ExceptionHandler(UniqueDataException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String UniqueDataHandler(UniqueDataException e) {
        return e.getMessage();
    }

}
