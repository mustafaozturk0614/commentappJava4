package com.bilgeadam.commentappJava4.controller;

import com.bilgeadam.commentappJava4.repository.entity.Like;
import com.bilgeadam.commentappJava4.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
yeni bir like oluşturmak için bir end point ve gerekli sınıflarda gerekli metotoları yazalım


 */
@RestController
@RequestMapping("/api/v1/like")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;


    @GetMapping("/save")
    public ResponseEntity<Like> save(long userId, long productId) {
        return ResponseEntity.ok(likeService.save(userId, productId));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Like>> findAll() {

        return ResponseEntity.ok(likeService.findAll());
    }

}
