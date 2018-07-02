package com.how2java.springboot.biz.shiro;

import com.how2java.springboot.common.result.BizResult;
import com.how2java.springboot.dao.bean.*;

import java.util.List;

public interface UsersAuthBiz {
    //获取登陆对象实体
    public BizResult<users> selectByLoginName(String loginName);
    //获取登录对象的角色
    public BizResult<String> selectByuserId(String userId);
    //获取权限
    public BizResult<String> selectByroleId(List<String> roleId);

    public void a();

}
