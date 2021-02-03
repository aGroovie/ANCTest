package drugstore.ukraine.dao;

import drugstore.ukraine.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

     User findByUsername(String userName);
     
}
