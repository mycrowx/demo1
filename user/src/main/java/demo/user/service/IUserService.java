package demo.user.service;

import demo.user.model.dto.UserDTO;
import java.util.List;

public interface IUserService {
    public void createUser(UserDTO user);

    public UserDTO getUserById(Long id);

    public List<UserDTO> getAllUsers();
}
