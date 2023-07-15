package com.ssamz.jblog.service;

 

import org.springframework.stereotype.Service;

 

import com.ssamz.jblog.entity.PostEntity;

import com.ssamz.jblog.repository.PostRepository;

 

import lombok.RequiredArgsConstructor;

 

@Service

@RequiredArgsConstructor

public class PostService {

    

    private final PostRepository postRepository;

    

    public void insertPost(PostEntity post) {

        post.setCnt(0);

        postRepository.save(post);

    }

    

}

 