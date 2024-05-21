package northwindProject.demo.core.dataAccess;

import northwindProject.demo.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface UserDao extends JpaRepository<User,Integer> {
     User findByEmail ( String email );


}

