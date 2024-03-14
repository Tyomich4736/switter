package by.nosevich.courses.switter.dto.user;

import lombok.Data;

@Data
public class SimpleUserDto {
    private Long id;
    private String nickname;
    private String avatarLink;
}
