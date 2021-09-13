package demo.user.controller;

import demo.user.mapper.IUserMapper;
import demo.user.model.dto.UserDTO;
import demo.user.model.request.UserCreateUserRequest;
import demo.user.service.IUserService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "user")
public class UserController {

    private IUserService service;
    private IUserMapper mapper;

    /**
     * @param service
     * @param mapper
     */
    public UserController(IUserService service, IUserMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public void createUser(
        @RequestBody UserCreateUserRequest createUserRequest
    ) {
        UserDTO userDTO = mapper.createUserRequestToUserDto(createUserRequest);

        service.createUser(userDTO);
    }

    @GetMapping(path = "/{userId}")
    public UserDTO getUserById(@PathVariable Long userId) {
        return service.getUserById(userId);
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return service.getAllUsers();
    }
}
