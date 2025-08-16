package com.linkedin.post_service.service;

import com.linkedin.post_service.dto.PostCreateRequestDto;
import com.linkedin.post_service.dto.PostDto;
import com.linkedin.post_service.entity.Post;
import com.linkedin.post_service.exception.CustomException;
import com.linkedin.post_service.repo.PostRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final PostRepo postRepo;

    private final ModelMapper modelMapper;

    public PostDto createPost(PostCreateRequestDto postCreateRequestDto, Long userId) {
        Post post = this.modelMapper.map(postCreateRequestDto, Post.class);
        post.setUserId(userId);
        return this.modelMapper.map(postRepo.save(post), PostDto.class);
    }

    public PostDto getPost(Long postId) {
        return this.modelMapper.map(postRepo.findById(postId).orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND.value(), "Post not found with postId :" + postId)), PostDto.class);

    }

    public List<PostDto> getAllPostOfUser(Long userId) {
        return postRepo.findByUserId(userId).stream().map(post -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

    }
}
