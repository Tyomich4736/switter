package by.nosevich.courses.switter.dto.post;

import lombok.Data;

@Data
public class CreatePostRequestDto {
    private String text;
    private Long ownerId;
}
