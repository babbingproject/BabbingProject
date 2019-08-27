package com.example.demo.service.login;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.mypage.UserVO;

public interface LoginRepository extends JpaRepository<UserVO, Integer>{

}
