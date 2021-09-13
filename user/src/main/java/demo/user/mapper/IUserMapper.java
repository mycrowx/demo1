package demo.user.mapper;

import demo.user.model.dto.UserDTO;
import demo.user.model.entity.UserEntity;
import demo.user.model.request.UserCreateUserRequest;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserMapper {
    UserEntity userDtoToUserEntity(UserDTO userDTO);

    UserDTO userEntityToUserDto(UserEntity userEntity);

    List<UserDTO> userEntitiesToUserDtos(List<UserEntity> userEntities);

    UserDTO createUserRequestToUserDto(UserCreateUserRequest createUserRequest);
}
