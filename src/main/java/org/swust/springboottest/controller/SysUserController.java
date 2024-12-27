package org.swust.springboottest.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.swust.springboottest.entity.R;
import org.swust.springboottest.entity.SysUser;
import org.swust.springboottest.service.ISysDepartmentService;
import org.swust.springboottest.service.ISysUserService;

/**
 * 用户表 前端控制器
 *
 * @author hurenjie
 * @since 2024-12-24
 */
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class SysUserController {
    private final ISysUserService userService;

    /**
     * 通过ID查询用户信息
     *
     * @param id ID
     * @return 用户信息
     */
    @GetMapping("/{id}")
    public R<SysUser> user(@PathVariable Integer id) {

        SysUser user = userService.getById(id);
        if (user == null) {
            return R.failed("用户不存在");
        }
        return R.ok(user);

    }

    /**
     * 添加用户
     *
     * @param user 用户信息
     * @return success/fail
     */
    @PostMapping("/add")
    public R<Integer> add(@RequestBody SysUser user) {
        userService.save(user);
        return R.ok(user.getUserId());
    }

    /**
     * 删除用户
     *
     * @param id ID
     * @return success/fail
     */
    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable Integer id) {
        boolean result = userService.removeById(id);
        return R.ok(result);
    }

    /**
     * 更新用户信息
     *
     * @param user 用户信息
     * @return success/fail
     */
    @PutMapping("/update")
    public R<Boolean> update(@RequestBody SysUser user) {
        boolean result = userService.updateById(user);
        return R.ok(result);
    }

    /**
     * 更新用户姓名
     *
     * @param user 用户信息
     * @return success/fail
     */
    @PutMapping("/editName")
    public R<Boolean> editName(@RequestBody SysUser user) {
        boolean result = userService.updateName(user);
        return result ? R.ok(true) : R.failed("更新失败");
    }

    /**
     * 分页查询用户
     *
     * @param page 分页对象
     * @param qSysUser 用户查询对象
     * @return 用户分页
     */
//    @GetMapping("/page")
//    public R getUserPage(Page page, SysUser qSysUser) {
//        return R.ok(userService.pageUser(page, qSysUser));
//    }
}
