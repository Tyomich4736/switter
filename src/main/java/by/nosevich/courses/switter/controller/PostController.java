package by.nosevich.courses.switter.controller;

import by.nosevich.courses.switter.dto.post.CreatePostRequestDto;
import by.nosevich.courses.switter.dto.post.DetailedPostDto;
import by.nosevich.courses.switter.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/post")
    public ResponseEntity<DetailedPostDto> createPost(@RequestBody CreatePostRequestDto createPostRequestDto) {
        DetailedPostDto detailedPost = postService.createPost(createPostRequestDto);
        if (detailedPost == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(detailedPost, HttpStatus.CREATED);
    }
}
