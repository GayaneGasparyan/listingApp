package com.example.listingapp.endPoint;

import com.example.listingapp.config.MapperConfiguration;
import com.example.listingapp.dto.UserDto;
import com.example.listingapp.dto.UserSaveDto;
import com.example.listingapp.model.User;
import com.example.listingapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

@RequiredArgsConstructor
public class UserEndPoint {

    private final UserService userService;
    private  final ModelMapper mapper;

    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : allUsers) {
            UserDto userDto = mapper.map(user, UserDto.class);
            userDtos.add(userDto);
        }
        return userDtos;

    }

    @GetMapping("/users/{id}")
    public User getById(int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User userById = userService.getUserById(user.getId());
        if (userById != null) {
            User body = userService.addUser(user);
            return ResponseEntity
                    .ok().body(body);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUSer(@PathVariable("id") int id) {
        userService.deleteUserByID(id);
    }

}
