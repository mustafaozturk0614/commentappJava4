package com.bilgeadam.commentappJava4.service;

import com.bilgeadam.commentappJava4.repository.ILikeRepository;
import com.bilgeadam.commentappJava4.repository.entity.Like;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeService {


    private final ILikeRepository repository;

    public void saveAll(List<Like> likes) {


        repository.saveAll(likes);
    }
}
