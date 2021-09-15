package demo.user.repository;

import demo.user.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserJPARepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
