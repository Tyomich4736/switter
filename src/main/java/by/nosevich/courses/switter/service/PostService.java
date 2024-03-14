package by.nosevich.courses.switter.service;

import by.nosevich.courses.switter.dto.post.CreatePostRequestDto;
import by.nosevich.courses.switter.dto.post.DetailedPostDto;
import by.nosevich.courses.switter.entity.Post;
import by.nosevich.courses.switter.entity.User;
import by.nosevich.courses.switter.mapper.PostMapper;
import by.nosevich.courses.switter.mapper.UserMapper;
import by.nosevich.courses.switter.repository.PostRepository;
import by.nosevich.courses.switter.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    public DetailedPostDto createPost(CreatePostRequestDto requestDto) {
        Post post = postMapper.convertCreatePostRequestToPost(requestDto);
        Optional<User> owner = userRepository.findById(requestDto.getOwnerId());
        if (owner.isEmpty()) {
            return null;
        }
        post.setOwner(owner.get());
        post = postRepository.save(post);
        DetailedPostDto detailedPostDto = postMapper.convertPostToDetailedPost(post);
        detailedPostDto.setOwner(userMapper.convertUserToSimpleUser(owner.get()));
        //TODO set converted comments to detailedPostDto
        return detailedPostDto;
    }
}
