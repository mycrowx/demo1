package demo.user.service;

import demo.user.mapper.IUserMapper;
import demo.user.model.dto.UserDTO;
import demo.user.model.entity.UserEntity;
import demo.user.repository.IUserJPARepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    private IUserJPARepository repository;
    private IUserMapper mapper;

    BCryptPasswordEncoder encoder;

    /**
     * @param repository
     * @param mapper
     */
    public UserServiceImpl(
        IUserJPARepository repository,
        IUserMapper mapper,
        BCryptPasswordEncoder encoder
    ) {
        this.repository = repository;
        this.mapper = mapper;
        this.encoder = encoder;
    }

    @Override
    public void createUser(UserDTO userDTO) {
        UserEntity userEntity = mapper.userDtoToUserEntity(userDTO);
        userEntity.setPassword(encoder.encode(userDTO.getPassword()));

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

    @Override
    public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException {
        UserEntity userEntity = repository.findByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }

        return new User(
            username,
            userEntity.getPassword(),
            true,
            true,
            true,
            true,
            new ArrayList<GrantedAuthority>()
        );
    }

    @Override
    public UserDTO findByUsername(String username) {
        UserEntity userEntity = repository.findByUsername(username);

        if (userEntity == null) {
            return null;
        }

        UserDTO userDTO = mapper.userEntityToUserDto(userEntity);
        return userDTO;
    }
}
