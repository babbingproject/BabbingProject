package com.example.demo.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.UserVO;

public interface UserRepository extends CrudRepository<UserVO, Integer>{

}
