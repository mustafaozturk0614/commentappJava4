package com.bilgeadam.commentappJava4.service;

import com.bilgeadam.commentappJava4.repository.IProductCommentRepository;
import com.bilgeadam.commentappJava4.repository.entity.ProductComment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCommentService {

    private final IProductCommentRepository productCommentRepository;

    public void saveAll(List<ProductComment> pc1) {
        productCommentRepository.saveAll(pc1);
    }

    public List<ProductComment> findAllByProductId(long productId) {

        return productCommentRepository.findAllByProductId(productId);
    }

    public List<ProductComment> findAllByCommentDateBetweenAndProductId(String now, String nextDate, long productId) {

        return productCommentRepository.findAllByCommentDateBetweenAndProductId(LocalDate.parse(now), LocalDate.parse(nextDate), productId);
    }

    public List<ProductComment> findAllByUserId(long userId) {
        return productCommentRepository.findAllByUserId(userId);
    }

    public List<ProductComment> findAllByCommentDateBetweenAndUserId(String now, String nextDate, long userId) {
        return productCommentRepository.findAllByCommentDateBetweenAndUserId(LocalDate.parse(now), LocalDate.parse(nextDate), userId);
    }

    public List<ProductComment> findAllByCommentContaining(String comment) {

        return productCommentRepository.findAllByCommentContaining(comment);
    }

    public List<ProductComment> findByCommentLength(int length) {
        return productCommentRepository.findByCommentLength(length);
    }

    public List<ProductComment> findByCommentLength2(int length) {
        return productCommentRepository.findByCommentLength2(length);
    }

    public List<ProductComment> findByCommentLength3(int length) {
        return productCommentRepository.findByCommentLength3(length);
    }
}
