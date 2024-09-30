package com.itwill.guest.mapper;

import java.util.List;

import org.apache.catalina.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.itwill.guest.Guest;

public interface GuestMapper {
	
	@ResultType(Guest.class)
	@Select("select * from guest order by guest_date desc")
	public List<Guest> findByAll();
	
}