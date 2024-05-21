package northwindProject.demo.business.abstracts;

import northwindProject.demo.core.entities.User;
import northwindProject.demo.core.utilities.results.DataResult;
import northwindProject.demo.core.utilities.results.Result;
import northwindProject.demo.entities.concretes.Product;

public
interface UserService {
    Result add( User user);
    DataResult<User> getByEmail( String email);



}
