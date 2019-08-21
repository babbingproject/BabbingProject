package com.example.demo.service.advertisement;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.mypage.Advertisementvo;

public interface AdvertisementRepository extends JpaRepository<Advertisementvo, Integer>{

}
