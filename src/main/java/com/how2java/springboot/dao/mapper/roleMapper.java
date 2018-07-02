package com.how2java.springboot.dao.mapper;

import com.how2java.springboot.dao.bean.role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface roleMapper {

    @Select("select *from role where id=#{roleId}")
    role selectByRoleId(@Param("roleId")String roleId);
}
