package com.linkedin.post_service.repo;

import com.linkedin.post_service.entity.PostLike;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface PostLikeRepo extends JpaRepository<PostLike,Long> {


    boolean existsByUserIdAndPostId(Long userId,Long postId);
@Transactional
@Modifying
    void deleteByUserIdAndPostId(Long userId,Long postId);
}
