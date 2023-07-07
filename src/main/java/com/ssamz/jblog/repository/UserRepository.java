package com.ssamz.jblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssamz.jblog.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}