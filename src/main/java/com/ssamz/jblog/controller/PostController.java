package com.ssamz.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor

public class PostController {
	@GetMapping("/post/instertPost")
	public String insertPost() {
		return "post/insertPost";
	}

}
