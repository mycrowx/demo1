package demo.user.config;

import demo.user.model.entity.UserEntity;
import demo.user.repository.IUserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataSeedingConfig {

    @Autowired
    private IUserJPARepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        if (repository.findByUsername("NguyenHoangNam") == null) {
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername("NguyenHoangNam");
            userEntity.setPassword(passwordEncoder.encode("123"));

            repository.save(userEntity);
        }
    }
}
