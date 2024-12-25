package org.swust.springboottest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.swust.springboottest.entity.R;
import org.swust.springboottest.entity.SysDepartment;
import org.swust.springboottest.service.ISysDepartmentService;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author hurenjie
 * @since 2024-12-25
 */
@RestController
@RequestMapping("/dept")
public class SysDepartmentController {2
    @Autowired
    private ISysDepartmentService deptService;

    @GetMapping("/{id}")
    public R<SysDepartment> getById(@PathVariable Integer id) {
        SysDepartment dept = deptService.getById(id);
        return R.ok(dept);
    }

    @PostMapping("/add")
    public R add(@RequestBody SysDepartment dept) {
        boolean result = deptService.save(dept);
        return R.ok(result);
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id) {
        boolean result = deptService.removeById(id);
        return R.ok(result);
    }

    @PutMapping("/update")
    public R update(@RequestBody SysDepartment dept) {
        boolean result = deptService.updateById(dept);
        return R.ok(result);
    }
}
