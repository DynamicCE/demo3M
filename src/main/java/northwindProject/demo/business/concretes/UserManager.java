package northwindProject.demo.business.concretes;

import northwindProject.demo.business.abstracts.UserService;
import northwindProject.demo.core.dataAccess.UserDao;
import northwindProject.demo.core.entities.User;
import northwindProject.demo.core.utilities.results.DataResult;
import northwindProject.demo.core.utilities.results.Result;
import northwindProject.demo.core.utilities.results.SuccessDataResult;
import northwindProject.demo.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public
class UserManager implements UserService {

    private UserDao userDao;
    @Autowired
    public
    UserManager ( UserDao userDao ) {
        this.userDao = userDao;
    }

    @Override
    public
    Result add ( User user ) {
        userDao.save ( user );
        return new SuccessResult ("kullanıcı eklendi");
    }

    @Override
    public
    DataResult<User> getByEmail ( String email ) {
        return new SuccessDataResult<User> (this.userDao.findByEmail ( email ),"kullanıcı bulundu");
    }
}
