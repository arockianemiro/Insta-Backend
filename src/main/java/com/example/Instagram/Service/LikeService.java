package com.example.Instagram.Service;

import com.example.Instagram.Model.Like;
import com.example.Instagram.Repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    public String toggleLike(Like like) {
        Optional<Like> existingLike = likeRepository.findByUserIdAndPostId(
                like.getUser().getId(), like.getPost().getId()
        );

        if (existingLike.isPresent()) {
            likeRepository.delete(existingLike.get());
            return "Post unliked";
        } else {
            likeRepository.save(like);
            return "Post liked";
        }
    }

    public long getLikeCount(Long postId) {
        return likeRepository.countByPostId(postId);
    }
}