package by.nosevich.courses.switter.controller;

import by.nosevich.courses.switter.dto.user.CreateUserRequestDto;
import by.nosevich.courses.switter.dto.user.DetailedUserDto;
import by.nosevich.courses.switter.dto.user.UpdateUserRequestDto;
import by.nosevich.courses.switter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<DetailedUserDto> createUser(@RequestBody CreateUserRequestDto createUserRequestDto) {
        DetailedUserDto detailedUser = userService.createUser(createUserRequestDto);
        return new ResponseEntity<>(detailedUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailedUserDto> getUser(@PathVariable("id") Long id) {
        DetailedUserDto detailedUser = userService.getUserById(id);
        if (detailedUser != null) {
            return new ResponseEntity<>(detailedUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        boolean isSuccessful = userService.deleteUser(id);
        return new ResponseEntity<>(isSuccessful ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<DetailedUserDto> updateUser(@RequestBody UpdateUserRequestDto updateUserRequestDto) {
        DetailedUserDto detailedUser = userService.updateUser(updateUserRequestDto);
        if (detailedUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(detailedUser, HttpStatus.OK);
    }
}
