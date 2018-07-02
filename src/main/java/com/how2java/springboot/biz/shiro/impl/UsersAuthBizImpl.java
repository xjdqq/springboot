package com.how2java.springboot.biz.shiro.impl;

import com.how2java.springboot.biz.shiro.UsersAuthBiz;
import com.how2java.springboot.common.result.BizResult;
import com.how2java.springboot.dao.bean.*;
import com.how2java.springboot.dao.mapper.rolePermissionMapper;
import com.how2java.springboot.dao.mapper.userRoleMapper;
import com.how2java.springboot.dao.mapper.usersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersAuthBizImpl implements UsersAuthBiz {

    @Autowired
    usersMapper usersMapper;
    @Autowired
    userRoleMapper userRoleMapper;
    @Autowired
    rolePermissionMapper rolePermissionMapper;

    @Override
    public BizResult<users> selectByLoginName(String loginName) {
        BizResult<users> bizResult = new BizResult<users>();
        bizResult.setResult(usersMapper.selectOneByLoginName(loginName));
        return bizResult;
    }

    @Override
    public BizResult<String> selectByuserId(String userId) {
        BizResult<String> bizResult= new BizResult<String>();
        List<userRole> list=userRoleMapper.selectByUserId(userId);
        List<String> list1=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            list1.add(list.get(i).getRid());
        }
        bizResult.setResults(list1);
        return bizResult;
    }

    @Override
    public BizResult<String> selectByroleId(List<String> roleId) {
        BizResult<String> bizResult= new BizResult<String>();
        List<String> list=new ArrayList<>();
        for(int i=0;i<roleId.size();i++){
            List<rolePermission> list1=new ArrayList<>();
            list1=rolePermissionMapper.selectByRoleId(roleId.get(i));
            for(int k=0;k<list1.size();k++){
                list.add(list1.get(k).getPid());
            }
        }
        bizResult.setResults(list);
        return bizResult;

    }

    @Override
    public void a() {
        System.out.println("我我我我");
    }

}
