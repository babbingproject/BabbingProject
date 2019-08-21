package com.example.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.UserVO;

public interface MemberRepository extends JpaRepository<UserVO, Long> {

}
