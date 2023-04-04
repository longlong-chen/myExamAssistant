package com.chenlong.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.chenlong.demo.entity.Admin;
import com.chenlong.demo.entity.Login;

@Mapper
public interface AdminMapper {
	
	@Update("update admin set administrator_password = #{password} where administrator_id = #{username}")
	int updatePwd(Login user);
	
	@Select("select * from admin where administrator_id = #{administratorId}")
    Admin findById(Integer administratorId);
	
	@Update("update admin set administrator_name = #{administratorName},administrator_password = #{administratorPassword},administrator_phone = #{administratorPhone},administrator_email = #{administratorEmail}," +
            "disabled_flag = #{disabledFlag},sex = #{sex} " +
            "where administrator_id = #{administratorId}")
	int update(Admin admin);
}
