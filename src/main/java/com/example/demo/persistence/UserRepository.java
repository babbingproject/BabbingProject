package com.example.demo.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.vo.UserVO;

public interface UserRepository extends CrudRepository<UserVO, Integer>{

}
