package demo.user.repository;

import demo.user.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserJPARepository extends CrudRepository<UserEntity, Long> {}
