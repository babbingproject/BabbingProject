package com.example.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.UserVO;

public interface LoginRepository extends JpaRepository<UserVO, Integer>{

}
