package by.nosevich.courses.switter.service;

import by.nosevich.courses.switter.dto.user.CreateUserRequestDto;
import by.nosevich.courses.switter.dto.user.DetailedUserDto;
import by.nosevich.courses.switter.dto.user.UpdateUserRequestDto;
import by.nosevich.courses.switter.entity.User;
import by.nosevich.courses.switter.mapper.UserMapper;
import by.nosevich.courses.switter.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    public DetailedUserDto createUser(CreateUserRequestDto createUserRequestDto) {
        User user = userMapper.convertCreateUserRequestToUser(createUserRequestDto);
        user = userRepository.save(user);
        return userMapper.convertUserToDetailedUser(user);
    }

    public DetailedUserDto getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            return null;
        }
        return userMapper.convertUserToDetailedUser(user.get());
    }

    public boolean deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            return false;
        }
        userRepository.delete(user.get());
        return true;
    }

    public DetailedUserDto updateUser(UpdateUserRequestDto requestDto) {
        Optional<User> userOptional = userRepository.findById(requestDto.getId());
        if (userOptional.isEmpty()) {
            return null;
        }
        User user = userOptional.get();

        user.setAvatarLink(requestDto.getAvatarLink());
        user.setBio(requestDto.getBio());
        user.setBirthDate(requestDto.getBirthDate());
        user.setCountry(requestDto.getCountry());
        user.setCity(requestDto.getCity());
        user.setPhoneNumber(requestDto.getPhoneNumber());

        user = userRepository.save(user);
        return userMapper.convertUserToDetailedUser(user);
    }
}
