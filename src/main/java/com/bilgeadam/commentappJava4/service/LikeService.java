package com.bilgeadam.commentappJava4.service;

import com.bilgeadam.commentappJava4.exception.CommentAppException;
import com.bilgeadam.commentappJava4.exception.ErrorType;
import com.bilgeadam.commentappJava4.repository.ILikeRepository;
import com.bilgeadam.commentappJava4.repository.entity.Like;
import com.bilgeadam.commentappJava4.repository.entity.Product;
import com.bilgeadam.commentappJava4.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {


    private final ILikeRepository repository;

    private final UserService userService;

    private final ProductService productService;

    public void saveAll(List<Like> likes) {


        repository.saveAll(likes);
    }

    public Like save(long userId, long productId) {
        Optional<User> user = userService.findById(userId);
        Optional<Product> product = productService.findById(productId);

        if (user.isPresent() && product.isPresent()) {
            try {
                return repository.save(Like.builder().productId(productId).user(user.get()).build());
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        } else {
            throw new CommentAppException(ErrorType.LIKE_NOT_CREATED);
        }
    }

    public List<Like> findAll() {
        return repository.findAll();
    }


}