package com.example.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Advertisementvo;

public interface AdvertisementRepository extends JpaRepository<Advertisementvo, Long>{

}
