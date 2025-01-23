package org.swust.springboottest.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.swust.springboottest.config.SecurityUserDetails;
import org.swust.springboottest.entity.SysUser;

import java.util.ArrayList;

@Component
@Slf4j
@AllArgsConstructor
public class SecurityUserDetailsService implements UserDetailsService {

    private final ISysUserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            SysUser user = userService.getOne(new QueryWrapper<SysUser>().eq("name", username));
            SecurityUserDetails userDetails = new SecurityUserDetails(username,
                    user.getPassword(), new ArrayList<>(),
                    true, true, true, true);
            userDetails.setUser(user);
            log.info("登录用户信息：{}", user);
            return userDetails;
        } catch (Exception e) {
            String msg = "username: " + username + " not found";
            log.error(msg, e);
            throw new UsernameNotFoundException(msg);
        }
    }
}