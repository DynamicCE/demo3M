package northwindProject.demo.api.controller;

import jakarta.validation.Valid;
import northwindProject.demo.business.abstracts.UserService;
import northwindProject.demo.core.entities.User;
import northwindProject.demo.core.utilities.results.ErrorDataResult;
import northwindProject.demo.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/users/")

public
class UsersController {

    private
    UserService userService;

    @Autowired
    public
    UsersController ( UserService userService ) {
        this.userService = userService;
    }

    @PostMapping("add")
    public
    ResponseEntity<Result> add ( @Valid @RequestBody User user ) {
        Result result = this.userService.add ( user );
        return ResponseEntity.ok ( result );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public
    ErrorDataResult<Object> handleValidationException
            ( MethodArgumentNotValidException exceptions ) {
        Map<String, String> validationErrors = new HashMap<String, String> ( );
        for (FieldError fieldError : exceptions.getBindingResult ( ).getFieldErrors ( )) {
            validationErrors.put ( fieldError.getField ( ), fieldError.getDefaultMessage ( ) );
        }

        ErrorDataResult<Object> errors
                = new ErrorDataResult<Object> ( validationErrors, "Doğrulama hataları" );
        return errors;
    }

}
