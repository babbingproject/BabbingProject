package com.example.demo.service.user;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.mypage.Uservo;

public interface UserRepository extends CrudRepository<Uservo, Integer>{

}
