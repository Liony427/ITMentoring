package com.ssamz.jblog.service;

import org.springframework.stereotype.Service;

import com.ssamz.jblog.entity.UserEntity;
import com.ssamz.jblog.exception.JBlogException;
import com.ssamz.jblog.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service

@RequiredArgsConstructor

public class UserService {

	private final UserRepository repository;

	public UserEntity findById(String id) {

		return repository.findById(Long.parseLong(id)).orElseThrow(() -> {

			return new JBlogException(id + "를 가진 회원이 존재하지 않습니다");

		});

	}

	public UserEntity update(UserEntity oldUser, UserEntity newUser) {

		UserEntity user = repository.findById(oldUser.getId()).orElseThrow(() -> {

			return new JBlogException(oldUser.getId() + "를 가진 회원이 존재하지 않습니다");

		});
		
		
		user.setEmail(newUser.getEmail());
		user.setUsername(newUser.getUsername());
		user.setPassword(newUser.getPassword());
		repository.save(user);
		return user;

	}
	
public UserEntity insertUser(UserEntity user) {

    return repository.save(user);

}


public void deleteById(String id) {
	UserEntity user = repository.findById(Long.parseLong(id)).orElseThrow(() -> {

        return new JBlogException(id + "를 가진 회원이 존재하지 않습니다");    

    });

    repository.delete(user);

}

}

