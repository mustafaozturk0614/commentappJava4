package com.bilgeadam.commentappJava4.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String surName;
    @Column(length = 50)
    private String email;
 
    private String password;
    @Column(length = 15)
    private String phone;

    @Enumerated(EnumType.STRING)
    private EUserType userType;

    @ElementCollection
    @Builder.Default
    List<Long> favProducts = new ArrayList<>();
    @OneToMany
    @Builder.Default
    private List<Like> likes = new ArrayList<>();
    @OneToMany
    @Builder.Default
    List<ProductComment> comments = new ArrayList<>();
}
