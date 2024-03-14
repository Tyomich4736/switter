package by.nosevich.courses.switter.mapper;

import by.nosevich.courses.switter.dto.user.CreateUserRequestDto;
import by.nosevich.courses.switter.dto.user.DetailedUserDto;
import by.nosevich.courses.switter.dto.user.SimpleUserDto;
import by.nosevich.courses.switter.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserMapper {
    public User convertCreateUserRequestToUser(CreateUserRequestDto requestDto) {
        User user = new User();
        user.setNickname(requestDto.getNickname());
        user.setAvatarLink(requestDto.getAvatarLink());
        user.setBio(requestDto.getBio());
        user.setCreationDate(LocalDateTime.now());
        user.setPassword(requestDto.getPassword()); //TODO hash password
        return user;
    }

    public DetailedUserDto convertUserToDetailedUser(User user) {
        if (user == null) {
            return null;
        }

        DetailedUserDto detailedUserDto = new DetailedUserDto();
        detailedUserDto.setId(user.getId());
        detailedUserDto.setBio(user.getBio());
        detailedUserDto.setNickname(user.getNickname());
        detailedUserDto.setAvatarLink(user.getAvatarLink());
        detailedUserDto.setBirthDate(user.getBirthDate());
        detailedUserDto.setCity(user.getCity());
        detailedUserDto.setCountry(user.getCountry());
        detailedUserDto.setPhoneNumber(user.getPhoneNumber());
        return detailedUserDto;
    }

    public SimpleUserDto convertUserToSimpleUser(User user) {
        SimpleUserDto simpleUserDto = new SimpleUserDto();
        simpleUserDto.setId(user.getId());
        simpleUserDto.setNickname(user.getNickname());
        simpleUserDto.setAvatarLink(user.getAvatarLink());
        return simpleUserDto;
    }
}
