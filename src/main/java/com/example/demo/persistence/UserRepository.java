package com.example.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.UserVO;

public interface UserRepository extends JpaRepository<UserVO, Integer>{

}
