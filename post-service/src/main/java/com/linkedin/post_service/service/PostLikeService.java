package com.linkedin.post_service.service;

import com.linkedin.post_service.entity.PostLike;
import com.linkedin.post_service.exception.CustomException;
import com.linkedin.post_service.repo.PostLikeRepo;
import com.linkedin.post_service.repo.PostRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostLikeService {
    private final PostLikeRepo postLikeRepo;
    private final PostRepo postRepo;


    public void likePost(Long postId, long userId) {
log.info("Attempting to like post with id : {}",postId);
boolean postExist= postRepo.existsById(postId);

if(!postExist)
{
    throw  new CustomException(HttpStatus.NOT_FOUND.value(), "Post not found with postId : "+postId);
}
boolean alreadyLiked =postLikeRepo.existsByUserIdAndPostId(userId,postId);

if(alreadyLiked)
{
    throw  new CustomException(HttpStatus.BAD_REQUEST.value(), "Post is already liked by user");
}


        PostLike postLike = new PostLike();
postLike.setPostId(postId);
postLike.setUserId(userId);
postLikeRepo.save(postLike);
        log.info("Post liked successfully : {}",postId);

    }

    public void unLikePost(Long postId, long userId) {

        log.info("Attempting to unlike post with id : {}",postId);
        boolean postExist= postRepo.existsById(postId);

        if(!postExist)
        {
            throw  new CustomException(HttpStatus.NOT_FOUND.value(), "Post not found with postId : "+postId);
        }
        boolean alreadyLiked =postLikeRepo.existsByUserIdAndPostId(userId,postId);

        if(!alreadyLiked)
        {
            throw  new CustomException(HttpStatus.BAD_REQUEST.value(), "Cannot unlike the Post which is not liked.");
        }



        postLikeRepo.deleteByUserIdAndPostId(userId,postId);
        log.info("Post unliked successfully : {}",postId);

    }
}
