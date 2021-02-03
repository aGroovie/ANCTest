package drugstore.ukraine.dao;

import drugstore.ukraine.entity.Family;
import drugstore.ukraine.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepository extends CrudRepository<Family, Long> {




}
