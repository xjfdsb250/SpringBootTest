package org.swust.springboottest.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.swust.springboottest.dto.CountDept;
import org.swust.springboottest.dto.SysUserDto;
import org.swust.springboottest.entity.R;
import org.swust.springboottest.entity.SysUser;
import org.swust.springboottest.entity.vo.QSysUser;
import org.swust.springboottest.service.ISysUserService;

import java.util.List;

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
    public R<SysUser> getUserById(@PathVariable Integer id) {

        SysUser user = userService.getById(id);
        if (user == null) {
            return R.failed("用户不存在");
        }
        return R.ok(user);

    }

    /**
     * 检查用户名是否存在
     *
     * @param name 用户名
     * @return 用户信息
     */
    @GetMapping("/name/{name}")
    public R<Boolean> checkUserExist(@PathVariable String name) {
        boolean result = userService.checkUserExist(name);
        return R.ok(result);

    }

    /**
     * 添加用户
     *
     * @param user 用户信息
     * @return success/fail
     */
    @PostMapping("/add")
    public R<Integer> add(@Valid @RequestBody SysUser user) {
        Integer res = userService.addUser(user);
        if (res == 1)
            return R.ok(user.getUserId());
        if (res == 0)
            return R.failed("用户名已存在");
        return R.failed("添加失败");
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
    public R<Boolean> update(@Valid @RequestBody SysUser user) {
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
    public R<Boolean> editName(@Valid @RequestBody SysUser user) {
        boolean result = userService.updateName(user);
        return result ? R.ok(true) : R.failed("更新失败");
    }

    /**
     * 分页查询用户
     *
     * @param page     分页对象
     * @param qSysUser 用户查询对象
     * @return 用户分页
     */
    @GetMapping("/page")
    public R<IPage<SysUserDto>> getUserPage(Page page, QSysUser qSysUser) {
        return R.ok(userService.pageUser(page, qSysUser));
    }

    /**
     * 更新用户角色
     *
     * @param user 用户信息
     * @return success/fail
     */
    @PutMapping("/updateRoleById")
    public R<Boolean> updateRoleById(@Valid @RequestBody SysUser user) {
        boolean result = userService.updateRoleById(user);
        return R.ok(result);
    }

    /**
     * 统计部门人数
     *
     * @return 部门人数
     */
    @GetMapping("/countNumByDeptId")
    public R<List<CountDept>> countNumByDeptId() {
        return R.ok(userService.countNumByDeptId());
    }

    /**
     * 重置密码
     *
     * @param userId 用户ID
     * @return success/fail
     */
    @PutMapping("/resetPassword")
    public R<Boolean> resetPassword(Integer userId) {
        boolean result = userService.resetPassword(userId);
        if (result) {
            return R.ok(true, "重置密码成功");
        } else {
            return R.failed("重置密码失败");
        }
    }


}
