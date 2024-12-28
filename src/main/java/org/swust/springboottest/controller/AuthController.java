package org.swust.springboottest.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.swust.springboottest.config.JwtTokenProvider;
import org.swust.springboottest.config.SecurityUserDetails;
import org.swust.springboottest.entity.R;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录控制器
 */
@RestController
@Slf4j
public class AuthController {

    private final Logger logger = LogManager.getLogger(getClass());

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return token
     */
    @PostMapping(value = "/login")
    public R authenticate(@Valid @RequestParam("username") @NotBlank(message = "用户名不能为空！") String username, @RequestParam("password") @NotBlank(message = "密码不能为空！") String password) {
        logger.debug("用户 {} 开始登录。", username);

        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

            SecurityUserDetails securityUserDetails = (SecurityUserDetails) authentication.getPrincipal();

            String token = jwtTokenProvider.createToken(securityUserDetails);
            Map<String, Object> model = new HashMap<>();
            model.put("userId", securityUserDetails.getUser().getUserId());
            model.put("username", securityUserDetails.getUser().getName());
            model.put("token", token);
            model.put("token_expiration", dateTimeFormatter.format(jwtTokenProvider.getTokenExpiration(token).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()));
            return R.ok(model);
        } catch (BadCredentialsException e) {
            return R.failed("账号或密码错误！");
        }
    }

    /**
     * 刷新token
     *
     * @param request 请求
     * @return token
     */
    @PostMapping(value = "/refresh")
    public R refreshToken(HttpServletRequest request) {
        String currToken = jwtTokenProvider.resolveToken(request);
        String newToken = jwtTokenProvider.refreshToken(currToken);
        Map<String, Object> model = new HashMap<>();
        model.put("username", jwtTokenProvider.getUsername(newToken));
        model.put("token", newToken);
        model.put("token_expiration", dateTimeFormatter.format(jwtTokenProvider.getTokenExpiration(newToken).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()));
        return R.ok(model);
    }

}