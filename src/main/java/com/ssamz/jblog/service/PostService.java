package com.ssamz.jblog.service;

 

import java.util.List;

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

 

    public List<PostEntity> getPostList() {

        return postRepository.findAll();

    }

 

    public PostEntity getPost(long id) {

        return postRepository.findById(id).get();

    }

 

    public void updatePost(PostEntity post) {

        PostEntity findPost = postRepository.findById(post.getId()).get();

        findPost.setContent(post.getContent());

        findPost.setTitle(post.getTitle());

        postRepository.save(findPost);

    }

    public void deletePost(long id) {

        postRepository.deleteById(id);

    }

 
}
