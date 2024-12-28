package org.swust.springboottest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.swust.springboottest.entity.R;
import org.swust.springboottest.entity.SysDepartment;
import org.swust.springboottest.service.ISysDepartmentService;

/**
 * 部门表 前端控制器
 *
 * @author hurenjie
 * @since 2024-12-25
 */
@RestController
@RequestMapping("/dept")
@AllArgsConstructor
public class SysDepartmentController {
    private final ISysDepartmentService deptService;

    /**
     * 通过ID查询部门信息
     *
     * @param id ID
     * @return 部门信息
     */
    @GetMapping("/{id}")
    public R<SysDepartment> getById(@PathVariable Integer id) {
        SysDepartment dept = deptService.getById(id);
        return R.ok(dept);
    }

    /**
     * 添加部门
     *
     * @param dept 部门信息
     * @return success/fail
     */
    @PostMapping("/add")
    public R<Boolean> add(@RequestBody SysDepartment dept) {
        boolean result = deptService.save(dept);
        return R.ok(result);
    }

    /**
     * 删除部门
     *
     * @param id ID
     * @return success/fail
     */
    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable Integer id) {
        boolean result = deptService.removeById(id);
        return R.ok(result);
    }

    /**
     * 更新部门信息
     *
     * @param dept 部门信息
     * @return success/fail
     */
    @PutMapping("/update")
    public R<Boolean> update(@RequestBody SysDepartment dept) {
        boolean result = deptService.updateById(dept);
        return R.ok(result);
    }
}
