package com.linkedin.post_service.controller;

import com.linkedin.post_service.service.PostLikeService;
import com.linkedin.post_service.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("likes")
@RequiredArgsConstructor
public class LikesController {

    private final PostLikeService postLikeService;

    @PostMapping("{postId}")
    public ResponseEntity<Void> likePost(@PathVariable Long postId) {
        postLikeService.likePost(postId, 1l);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("{postId}")
    public ResponseEntity<Void> unLikePost(@PathVariable Long postId) {
        postLikeService.unLikePost(postId, 1l);
        return ResponseEntity.noContent().build();
    }
}
