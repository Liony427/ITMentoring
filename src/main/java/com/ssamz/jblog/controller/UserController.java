package com.ssamz.jblog.controller;
 
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssamz.jblog.dto.ResponseDTO;
import com.ssamz.jblog.entity.UserEntity;
import com.ssamz.jblog.service.UserService;

import lombok.RequiredArgsConstructor;

 

@Controller

@RequiredArgsConstructor

public class UserController {

 

    private final UserService userService;

 

    // http://localhost:8080/user/get/1
    @GetMapping("/user/get/{id}")
    public @ResponseBody UserEntity getUser(@PathVariable String id) {
        // 특정 id 에 해당하는 User 객체 리턴
        UserEntity findUser = userService.findById(id);
        return findUser;
    }

    
    @PutMapping("/user")
    public @ResponseBody UserEntity updateUser(@RequestBody UserEntity user) {
    	UserEntity oldUser = userService.findById(user.getId() + "");
    	UserEntity newUser = userService.update(oldUser, user);
    	return newUser;
    }

    @GetMapping("/auth/insertUser")
    public String insertUser() {
        return "user/insertUser";
    }

//http://localhost:8080/user

@PostMapping("/user")

public @ResponseBody UserEntity insertUser(@RequestBody UserEntity user) {

    UserEntity ret = userService.insertUser(user);

    return ret;

    }


// http://localohst:8080/user

@DeleteMapping("/user/delete/{id}")

public @ResponseBody String deleteUser(@PathVariable String id) {

    userService.deleteById(id);

    return "";

}

@PostMapping("/auth/insertUser")

public @ResponseBody ResponseDTO<?> registerUser(@RequestBody UserEntity user) {

    UserEntity findUser = userService.selectUserByUserName(user.getUsername());



    if(findUser == null) {

        userService.insertUser(user);

        return new ResponseDTO<>(HttpStatus.OK.value(), user.getUsername() + "님 회원가입 성공하셨습니다.!");

    } else {

        return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), user.getUsername() + "님은 이미 회원입니다.!");            

    }}
       @GetMapping("/auth/login")
       public String loginUser() {
	   return "system/login";

}

       
       @PostMapping("/auth/login")
       public @ResponseBody ResponseDTO<?> login(@RequestBody UserEntity user, HttpSession session) {
    	   UserEntity findUser = userService.selectUserByUserName(user.getUsername());
    	
    	// 유저가 존재하지 않는다면

           if(findUser == null) {

               return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "아이디가 존재하지 않습니다");

           } else { // 유저가 존재한다면

               if(user.getPassword().equals(findUser.getPassword())) {

                   session.setAttribute("principal", findUser); // 세션에 정보를 저장한다.

                   return new ResponseDTO<>(HttpStatus.OK.value(), findUser.getUsername() + "로그인 성공하셨습니다!");            

               }else {

                   return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "비밀번호가 다릅니다");

               }

               

           }
    	   
}

       
}








