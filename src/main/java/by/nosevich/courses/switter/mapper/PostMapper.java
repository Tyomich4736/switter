package by.nosevich.courses.switter.mapper;

import by.nosevich.courses.switter.dto.post.CreatePostRequestDto;
import by.nosevich.courses.switter.dto.post.DetailedPostDto;
import by.nosevich.courses.switter.entity.Post;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PostMapper {

    public Post convertCreatePostRequestToPost(CreatePostRequestDto requestDto) {
        Post post = new Post();
        post.setText(requestDto.getText());
        post.setCreationDate(LocalDateTime.now());
        return post;
    }

    public DetailedPostDto convertPostToDetailedPost(Post post) {
        if (post == null) {
            return null;
        }

        DetailedPostDto detailedPostDto = new DetailedPostDto();
        detailedPostDto.setId(post.getId());
        detailedPostDto.setText(post.getText());
        detailedPostDto.setCreationDate(post.getCreationDate());
        return detailedPostDto;
    }
}
