package by.nosevich.courses.switter.dto.user;

import lombok.Data;

@Data
public class CreateUserRequestDto {
    private String nickname;
    private String password;
    private String avatarLink;
    private String bio;
}
