package com.ssamz.jblog.controller;

 

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssamz.jblog.dto.ResponseDTO;
import com.ssamz.jblog.entity.PostEntity;
import com.ssamz.jblog.entity.UserEntity;
import com.ssamz.jblog.service.PostService;

import lombok.RequiredArgsConstructor;

 

@Controller

@RequiredArgsConstructor

public class PostController {

    

    private final PostService postService;

 

    @GetMapping("/post/insertPost")

    public String insertPost() {

        return "post/insertPost";

    }

 

    @PostMapping("/post")

    public @ResponseBody ResponseDTO<?>

    insertPost(@RequestBody PostEntity post, HttpSession session) {

 

        UserEntity user = (UserEntity) session.getAttribute("principal");

        post.setUser(user);

        post.setCnt(0);

        

        postService.insertPost(post);

        

        return new ResponseDTO<>(HttpStatus.OK.value(), "새로운 포스트를 등록했습니다.");

        

    }

    @GetMapping({"", "/"})

    public String getPostList(Model model) {

        model.addAttribute("postList", postService.getPostList());

        return "index";

    }

}

 