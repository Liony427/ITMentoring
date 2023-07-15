package com.ssamz.jblog.entity;

 

import javax.persistence.Column;

import javax.persistence.ConstraintMode;

import javax.persistence.Entity;

import javax.persistence.FetchType;

import javax.persistence.ForeignKey;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

import javax.persistence.JoinColumn;

import javax.persistence.Lob;

import javax.persistence.ManyToOne;

 

import lombok.AllArgsConstructor;

import lombok.Builder;

import lombok.Data;

import lombok.NoArgsConstructor;

 

@Data

@AllArgsConstructor

@NoArgsConstructor

@Builder

@Entity(name = "POSTS")

public class PostEntity {

 

    @Id

    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "post_id")
    private Long id;

    

    @Column(nullable = false, length = 100, name = "post_title")

    private String title;

    

    // 대용량 데이터 저장을 위해서 Lob를 따로 저장

    @Lob

    @Column(name = "post_content", columnDefinition = "LONGTEXT")

    private String content;

    

    // 다대일 단방향 매핑(다대일 : post가 다(n), user가 일(1) / 단방향 : post -> user)

    @ManyToOne(fetch = FetchType.EAGER)

    @JoinColumn(name = "user_id", referencedColumnName = "user_id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))

    private UserEntity user;

    

    @Column(name = "post_cnt")

    private int cnt;

    

}

 