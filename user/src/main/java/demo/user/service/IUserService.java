package demo.user.service;

import demo.user.model.dto.UserDTO;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    public void createUser(UserDTO user);

    public UserDTO getUserById(Long id);

    public List<UserDTO> getAllUsers();

    public UserDTO findByUsername(String username);
}
