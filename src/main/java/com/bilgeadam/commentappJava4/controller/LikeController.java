package com.bilgeadam.commentappJava4.controller;

import com.bilgeadam.commentappJava4.dto.request.LikeCreateRequestDto;
import com.bilgeadam.commentappJava4.dto.response.LikeResponseDto;
import com.bilgeadam.commentappJava4.repository.entity.Like;
import com.bilgeadam.commentappJava4.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/save2")
    public ResponseEntity<LikeResponseDto> save2(@RequestBody LikeCreateRequestDto dto) {
        return ResponseEntity.ok(likeService.save2(dto));
    }

    @PostMapping("/save3")
    public ResponseEntity<Like> save3(@RequestBody LikeCreateRequestDto dto) {
        return ResponseEntity.ok(likeService.toLike(dto));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Like>> findAll() {

        return ResponseEntity.ok(likeService.findAll());
    }

}
