package com.bilgeadam.commentappJava4.controller;

import com.bilgeadam.commentappJava4.repository.entity.ProductComment;
import com.bilgeadam.commentappJava4.service.ProductCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/productcomment")
public class ProductCommentController {

    private final ProductCommentService productCommentService;

    @GetMapping("/findbyproductid")
    public ResponseEntity<List<ProductComment>> findAllByProductId(long productId) {
        return ResponseEntity.ok(productCommentService.findAllByProductId(productId));
    }

    @GetMapping("/findbycommentdateandproductid")
    public ResponseEntity<List<ProductComment>> findAllByCommentDateBetweenAndProductId(String now, String nextDate, long productId) {

        return ResponseEntity.ok(productCommentService.findAllByCommentDateBetweenAndProductId(now, nextDate, productId));
    }

    @GetMapping("/findbyuserid")
    public ResponseEntity<List<ProductComment>> findAllByUserId(long userId) {
        return ResponseEntity.ok(productCommentService.findAllByUserId(userId));
    }

    @GetMapping("/findbycommentdateanduserid")
    public ResponseEntity<List<ProductComment>> findAllByCommentDateBetweenAndUserId(String now, String nextDate, long userId) {
        return ResponseEntity.ok(productCommentService.findAllByCommentDateBetweenAndUserId(now, nextDate, userId));
    }

    @GetMapping("/findbycommentcontains")
    public ResponseEntity<List<ProductComment>> findAllByCommentContaining(String comment) {

        return ResponseEntity.ok(productCommentService.findAllByCommentContaining(comment));
    }

    @GetMapping("/findbycommentlength")
    public ResponseEntity<List<ProductComment>> findByCommentLength(int length) {

        return ResponseEntity.ok(productCommentService.findByCommentLength(length));
    }

    @GetMapping("/findbycommentlength2")
    public ResponseEntity<List<ProductComment>> findByCommentLength2(int length) {

        return ResponseEntity.ok(productCommentService.findByCommentLength2(length));
    }

    @GetMapping("/findbycommentlength3")
    public ResponseEntity<List<ProductComment>> findByCommentLength3(int length) {

        return ResponseEntity.ok(productCommentService.findByCommentLength3(length));
    }
}
