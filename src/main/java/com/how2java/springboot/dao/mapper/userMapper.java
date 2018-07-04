package com.how2java.springboot.dao.mapper;

import com.how2java.springboot.dao.bean.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface userMapper {
//    @Select("select id as id,name as name,password as password,sex as sex,is_open as isOpen from users where id=#{id}")
//    user selectOne(@Param("id") String id);
}
