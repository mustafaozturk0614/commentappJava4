package com.bilgeadam.commentappJava4.service;

import com.bilgeadam.commentappJava4.dto.request.LikeCreateRequestDto;
import com.bilgeadam.commentappJava4.dto.response.LikeResponseDto;
import com.bilgeadam.commentappJava4.exception.CommentAppException;
import com.bilgeadam.commentappJava4.exception.ErrorType;
import com.bilgeadam.commentappJava4.mapper.LikeMapper;
import com.bilgeadam.commentappJava4.repository.ILikeRepository;
import com.bilgeadam.commentappJava4.repository.entity.Like;
import com.bilgeadam.commentappJava4.repository.entity.Product;
import com.bilgeadam.commentappJava4.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

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
            if (controlLikes(user.get().getLikes(), productId)) {
                Like like = new Like();
                try {
                    like.setUser(user.get());
                    like.setProduct(product.get());
                    repository.save(like);
                    user.get().getLikes().add(like);
                    product.get().getLikes().add(like);
                    userService.save(user.get());
                    productService.save(product.get());
                    return like;
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
            } else {
                throw new CommentAppException(ErrorType.LIKE_ALREADY_EXIST);
            }
        } else {
            throw new CommentAppException(ErrorType.LIKE_NOT_CREATED);
        }
    }

    public List<Like> findAll() {
        return repository.findAll();
    }


    public boolean controlLikes(List<Like> likes, long productId) {

        AtomicBoolean control = new AtomicBoolean(true);
        for (Like like : likes) {
            if (like.getProduct().getId() == productId) {
                control.set(false);
                break;
            }
        }
/*        likes.stream().forEach(l -> {

            if (l.getProduct().getId() == productId) {
                control.set(false);
            }

        });*/
        return control.get();
    }

    public LikeResponseDto save2(LikeCreateRequestDto dto) {
        Optional<User> user = userService.findById(dto.getUserId());
        Optional<Product> product = productService.findById(dto.getProductId());
        if (user.isPresent() && product.isPresent()) {
            if (controlLikes(user.get().getLikes(), dto.getProductId())) {
                Like like = new Like();
                try {
                    like.setUser(user.get());
                    like.setProduct(product.get());
                    repository.save(like);
                    user.get().getLikes().add(like);
                    product.get().getLikes().add(like);
                    userService.save(user.get());
                    productService.save(product.get());
                    return LikeMapper.INSTANCE.toLikeResponseDto(dto);
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
            } else {
                throw new CommentAppException(ErrorType.LIKE_ALREADY_EXIST);
            }
        } else {
            throw new CommentAppException(ErrorType.LIKE_NOT_CREATED);
        }
    }
}