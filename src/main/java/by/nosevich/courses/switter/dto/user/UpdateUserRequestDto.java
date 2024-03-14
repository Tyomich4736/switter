package by.nosevich.courses.switter.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateUserRequestDto {
    private Long id;
    private String avatarLink;
    private String bio;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;
    private String country;
    private String city;
    private String phoneNumber;
}
