package com.example.Instagram.Controller;

import com.example.Instagram.Model.Like;
import com.example.Instagram.Service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping("/toggle")
    public String toggleLike(@RequestBody Like like) {
        return likeService.toggleLike(like);
    }

    @GetMapping("/post/{postId}/count")
    public long getLikeCount(@PathVariable Long postId) {
        return likeService.getLikeCount(postId);
    }
}