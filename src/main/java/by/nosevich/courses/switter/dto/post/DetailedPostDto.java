package by.nosevich.courses.switter.dto.post;

import by.nosevich.courses.switter.dto.comment.CommentDto;
import by.nosevich.courses.switter.dto.user.SimpleUserDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class DetailedPostDto {
    private Long id;
    private String text;
    private SimpleUserDto owner;
    private LocalDateTime creationDate;
    private List<CommentDto> comments;
}
