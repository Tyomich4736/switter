package by.nosevich.courses.switter.dto.user;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DetailedUserDto {
    private Long id;
    private String nickname;
    private String avatarLink;
    private String bio;
    private LocalDate birthDate;
    private String country;
    private String city;
    private String phoneNumber;
}
