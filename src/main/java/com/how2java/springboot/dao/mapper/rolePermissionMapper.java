package com.how2java.springboot.dao.mapper;

import com.how2java.springboot.dao.bean.rolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface rolePermissionMapper {
    @Select("select *from role_permission where rid=#{roleId}")
    List<rolePermission> selectByRoleId(@Param("roleId")String roleId);
}
