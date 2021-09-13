package demo.user.service;

import demo.user.mapper.IUserMapper;
import demo.user.model.dto.UserDTO;
import demo.user.model.entity.UserEntity;
import demo.user.repository.IUserJPARepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    private IUserJPARepository repository;
    private IUserMapper mapper;

    /**
     * @param repository
     * @param mapper
     */
    public UserServiceImpl(IUserJPARepository repository, IUserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void createUser(UserDTO userDTO) {
        UserEntity userEntity = mapper.userDtoToUserEntity(userDTO);

        repository.save(userEntity);
    }

    @Override
    public UserDTO getUserById(Long id) {
        UserEntity userEntity = repository
            .findById(id)
            .orElseThrow(() -> new IllegalStateException("User not found"));

        UserDTO userDTO = mapper.userEntityToUserDto(userEntity);
        return userDTO;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> userEntities = new ArrayList<UserEntity>();
        repository.findAll().forEach(userEntities::add);

        List<UserDTO> userDTOs = mapper.userEntitiesToUserDtos(userEntities);
        return userDTOs;
    }
}
