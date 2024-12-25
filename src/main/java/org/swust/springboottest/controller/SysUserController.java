package org.swust.springboottest.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.swust.springboottest.entity.R;
import org.swust.springboottest.entity.SysUser;
import org.swust.springboottest.service.ISysUserService;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author hurenjie
 * @since 2024-12-24
 */
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private ISysUserService userService;

    /**
     * 通过ID查询用户信息
     *
     * @param id ID
     * @return 用户信息
     */
    @GetMapping("/{id}")
    public R<SysUser> user(@PathVariable Integer id) {
        SysUser user = userService.getById(id);
        return R.ok(user);
    }

    /**
     * 添加用户
     *
     * @param user 用户信息
     * @return success/fail
     */
    @PostMapping("/add")
    public R add(@RequestBody SysUser user) {
        userService.save(user);
        return R.ok(user.getUserId());
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id) {
        boolean result = userService.removeById(id);
        return R.ok(result);
    }

    @PutMapping("/update")
    public R update(@RequestBody SysUser user) {
        boolean result = userService.updateById(user);
        return R.ok(result);
    }
}
