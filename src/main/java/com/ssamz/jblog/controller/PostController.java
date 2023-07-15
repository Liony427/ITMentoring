
package com.ssamz.jblog.controller;

 

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    public @ResponseBody ResponseDTO<?> insertPost(@RequestBody PostEntity post, HttpSession session) {

 

        // Post객체를 영속화하기 전에 연관된 UserEntity 설정

        UserEntity user = (UserEntity) session.getAttribute("principal");

        post.setUser(user);

        post.setCnt(0);

 

        postService.insertPost(post);

 

        return new ResponseDTO<>(HttpStatus.OK.value(), "새로운 포스트를 등록했습니다.");

    }

 

    @GetMapping({ "", "/" })

    public String getPostList(Model model) {

        model.addAttribute("postList", postService.getPostList());

        return "index";

    }

 

    @GetMapping("/post/{id}")

    public String getPost(@PathVariable long id, Model model) {

        model.addAttribute("post", postService.getPost(id));

        return "post/getPost";

    }

    

    @GetMapping("/post/updatePost/{id}")

    public String updatePost(@PathVariable int id, Model model) {

        model.addAttribute("post", postService.getPost(id));

        return "post/updatePost";

    }

    

    @PutMapping("/post")

    public @ResponseBody ResponseDTO<?> updatePost(@RequestBody PostEntity post) {

        postService.updatePost(post);  

        return new ResponseDTO<>(HttpStatus.OK.value(), post.getId() + "번 포스트를 수정했습니다.");

    }

    

    @DeleteMapping("/post/{id}")

    public @ResponseBody ResponseDTO<?> deletePost(@PathVariable long id) {

        postService.deletePost(id);

        return new ResponseDTO<>(HttpStatus.OK.value(), id + "번 포스트를 삭제했습니다.");

    }

    

 

}