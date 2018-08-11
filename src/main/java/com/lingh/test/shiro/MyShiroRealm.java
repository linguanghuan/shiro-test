package com.lingh.test.shiro;

import com.lingh.test.db.entity.TResource;
import com.lingh.test.db.entity.TUser;
import com.lingh.test.service.ResourceService;
import com.lingh.test.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.List;

public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Resource
    private ResourceService resourcesService;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        TUser user = (TUser) SecurityUtils.getSubject().getPrincipal();
        List<TResource> resourceList = resourcesService.getByUserId(user.getId());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (TResource tResource : resourceList) {
            info.addStringPermission(tResource.getResourceUrl());
        }
        return info;
    }

    // 获取认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        TUser user  = userService.getByUsername(username);
        if (user == null) {
            throw new UnknownAccountException();
        }

        if (user.getEnable()== 0) {
            throw new LockedAccountException();
        }

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
                ByteSource.Util.bytes(username),
                getName()
        );
        return simpleAuthenticationInfo;
    }
}
