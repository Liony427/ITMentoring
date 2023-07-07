package com.ssamz.jblog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "USERS")
public class UserEntity {

	// Primary Key와 매핑되는 식별자 변수
	@Id

	// 1부터 시작하여 자동으로 1씩 증가하도록 증가 전략 설정
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "user_id")

	private Long id;

	@Column(nullable = false, length = 50, unique = true, name = "user_name")

	private String username; // 아이디

	@Column(length = 100, name = "user_password")

	private String password; // 비밀번호(해쉬를 이용한 암호화를 할 것이므로 사이즈를 넉넉히)

	@Column(nullable = false, length = 100, name = "user_email")

	private String email;

}