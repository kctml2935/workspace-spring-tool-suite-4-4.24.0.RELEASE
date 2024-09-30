package com.itwill.user.mapper;

import java.util.List;


import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itwill.user.User;

public interface UserMapper {

	@ResultType(User.class)
	@Select("select * from User order by userid")
	public List<User> findByAll();
	
	
	@Update("update  userinfo set password=#{password},name=#{name},email=#{email} where userid=#{userId}")
	int updateUserById(User updateUser);
}
