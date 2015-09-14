package com.zhaoyan.webserver.web.security;


import com.zhaoyan.webserver.domain.account.db.UserModel;
import com.zhaoyan.webserver.service.account.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetailsService implements UserDetailsService{
    private Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = null;
        UserModel userModel = userService.getUser(username, username);
        if (userModel != null) {
            userDetails = new User(userModel.username, userModel.password
                    .toLowerCase(), true, true, true, true,
                    getAuthorities(userModel.access));
        }
        return userDetails;
    }

    /**
     * 获得访问角色权限
     *
     * @param access
     * @return
     */
    public Collection<GrantedAuthority> getAuthorities(Integer access) {

        List<GrantedAuthority> authList = new ArrayList<>(2);

        // 所有的用户默认拥有ROLE_USER权限
        logger.debug("Grant ROLE_USER to this user");
        authList.add(new GrantedAuthorityImpl("ROLE_USER"));

        // 如果参数access为1.则拥有ROLE_ADMIN权限
        if (access == 1) {
            logger.debug("Grant ROLE_ADMIN to this user");
            authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
        }

        return authList;
    }
}
