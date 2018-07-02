package com.how2java.springboot.shiro.realms;

import com.how2java.springboot.biz.shiro.UsersAuthBiz;
import com.how2java.springboot.biz.shiro.impl.UsersAuthBizImpl;
import com.how2java.springboot.common.result.BizResult;
import com.how2java.springboot.dao.bean.users;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class MyShiroRealm extends AuthorizingRealm {

@Autowired
    UsersAuthBiz usersAuthBiz;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("进入第一个");
        // 初始化认证对象
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        users users = (users) principalCollection.getPrimaryPrincipal();
        // 查询用户所有角色Code
        BizResult<String> roleCodes = usersAuthBiz.selectByuserId(users.getId());
        // 判断查询结果是否正确if(roleCodes.success)
        authorizationInfo.addRoles(roleCodes.getResults());
        BizResult<String> pers = usersAuthBiz.selectByroleId(roleCodes.getResults());
        authorizationInfo.addStringPermissions(pers.getResults());
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("进入第二个");
        //获取登录账号
        String loginName = (String) authenticationToken.getPrincipal();
        System.out.println(loginName);
        //获取对象
        BizResult<users> usersResult = usersAuthBiz.selectByLoginName(loginName);
        //获取对象
        users users = usersResult.getResult();

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(users,
                // loginUsers.getLoginPassword(): 加密后的密码
                users.getPassword(), getName());

        if (StringUtils.isNotBlank(users.getSalt())) {
            info.setCredentialsSalt(ByteSource.Util.bytes(users.getSalt()));
        }
        return info;
    }
}
