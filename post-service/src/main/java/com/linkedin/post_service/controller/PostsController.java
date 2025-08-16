package com.linkedin.post_service.controller;

import com.linkedin.post_service.dto.PostCreateRequestDto;
import com.linkedin.post_service.dto.PostDto;
import com.linkedin.post_service.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/core")
@RequiredArgsConstructor
public class PostsController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostCreateRequestDto postCreateRequestDto, HttpServletRequest httpServletRequest) {

        return ResponseEntity.status(HttpStatus.CREATED).body( postService.createPost(postCreateRequestDto, 1l));
    }

    @GetMapping("{postId}")
    public ResponseEntity<PostDto> getPost( @PathVariable Long postId) {
        return ResponseEntity.status(HttpStatus.OK).body( postService.getPost(postId));
    }




    @GetMapping("users/{userId}/allPosts")
    public ResponseEntity<List<PostDto>> getAllPostOfUser(@PathVariable Long userId)
    {
        return ResponseEntity.status(HttpStatus.OK).body( postService.getAllPostOfUser(userId));
    }
}
