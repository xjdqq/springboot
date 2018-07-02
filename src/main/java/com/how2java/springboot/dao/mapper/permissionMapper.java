package com.how2java.springboot.dao.mapper;

import com.how2java.springboot.dao.bean.permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface permissionMapper {
    @Select("select *from permission where id=#{pId}")
    permission selectByRoleId(@Param("pId")String pId);
}
