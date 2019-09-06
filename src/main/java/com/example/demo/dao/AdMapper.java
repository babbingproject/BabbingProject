package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.domain.mypage.Advertisementvo;

@Mapper
public interface AdMapper {
	int joinAd(Advertisementvo vo);

	int ademailCheck(String advertisement_email);

	int adnickCheck(String advertisement_name);

	public int alter_adKey(String advertisement_email, String key);

	public int GetKey(String advertisement_email, String key);
	
	public Advertisementvo loginAd(@Param("advertisement_email")String advertisement_email, @Param("password")String password);
}
