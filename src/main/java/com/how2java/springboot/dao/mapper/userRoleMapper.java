package com.how2java.springboot.dao.mapper;

import com.how2java.springboot.dao.bean.userRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface userRoleMapper {
    @Select("select *from user_role where uid=#{userId}")
    List<userRole> selectByUserId(@Param("userId") String userId);
}
