package com.ssamz.jblog.repository;

 

import org.springframework.data.jpa.repository.JpaRepository;

 

import com.ssamz.jblog.entity.PostEntity;

 

public interface PostRepository extends JpaRepository<PostEntity, Long>{

 

}

 