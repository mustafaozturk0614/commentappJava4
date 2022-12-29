package com.bilgeadam.commentappJava4.service;

import com.bilgeadam.commentappJava4.exception.CommentAppException;
import com.bilgeadam.commentappJava4.exception.ErrorType;
import com.bilgeadam.commentappJava4.repository.IUserRepository;
import com.bilgeadam.commentappJava4.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {


    private final IUserRepository userRepository;


    public List<User> findOrderByName() {

        return userRepository.findAllByOrderByName();

    }

    public Optional<List<User>> findAllByNameContains(String value) {

        Optional<List<User>> list = userRepository.findAllOptionalByNameContainingIgnoreCase(value);

        if (list.get().size() == 0) {
            throw new CommentAppException(ErrorType.VALUE_NOT_FOUND_IN_NAMES);
        } else {
            // Optional.ofNullable(list);
            //  return Optional.empty();
            return list;
        }

    }

    public Optional<List<User>> findAllByEmailContains(String value) {

        Optional<List<User>> list = userRepository.findAllOptionalByEmailContainingIgnoreCase(value);

        if (list.get().size() == 0) {
            throw new CommentAppException(ErrorType.VALUE_NOT_FOUND_IN_EMAILS);
        } else {
            // Optional.ofNullable(list);
            //  return Optional.empty();
            return list;

        }

    }

    public Optional<List<User>> findAllByEmailEnding(String value) {

        Optional<List<User>> list = userRepository.findAllOptionalByEmailEndingWithIgnoreCase(value);

        if (list.get().size() == 0) {
            throw new CommentAppException(ErrorType.VALUE_NOT_FOUND_IN_EMAILS);
        } else {
            // Optional.ofNullable(list);
            //  return Optional.empty();
            return list;

        }

    }

    public void saveAll(List<User> user) {

        userRepository.saveAll(user);

    }

    public Optional<User> login(String email, String password) {

        Optional<User> optionalUser = userRepository.findOptionalByEmailAndPassword(email, password);

        if (optionalUser.isPresent()) {
            return optionalUser;
        }

        throw new CommentAppException(ErrorType.USER_NOT_FOUND);
    }


    public List<User> passwordControl(int length) {
        return userRepository.controlPassword(length);
    }

    public List<User> passwordControl2(int length) {
        return userRepository.controlPassword2(length);
    }
}
