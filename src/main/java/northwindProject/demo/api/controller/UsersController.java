package northwindProject.demo.api.controller;

import northwindProject.demo.business.abstracts.UserService;
import northwindProject.demo.core.entities.User;
import northwindProject.demo.core.utilities.results.ErrorDataResult;
import northwindProject.demo.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping(value = "/add")
    public
    ResponseEntity<Result> add( @RequestBody User user){
        return ResponseEntity.ok ( this.userService.add ( user ) );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public
    ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String,String> (  );
        for(FieldError fieldError : exceptions.getBindingResult ().getFieldErrors ()) {
            validationErrors.put ( fieldError.getField (),fieldError.getDefaultMessage () );
            ErrorDataResult<Object> errors = new ErrorDataResult<Object> (validationErrors,"Doğrulama hataları"  );
            return errors;
        }
    }

}
