package com.how2java.springboot.dao.mapper;

import com.how2java.springboot.dao.bean.users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface usersMapper {

    @Select("select *from user where name=#{loginName}")
    users selectOneByLoginName(@Param("loginName")String loginName);
}
