package by.nosevich.courses.switter.dto.comment;

import by.nosevich.courses.switter.dto.user.SimpleUserDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDto {
    private Long id;
    private String text;
    private SimpleUserDto owner;
    private LocalDateTime creationDate;
}
