package org.swust.springboottest.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.swust.springboottest.entity.dto.SysDepartmentDto;
import org.swust.springboottest.entity.dto.SysDepartmentTree;
import org.swust.springboottest.entity.SysDepartment;
import org.swust.springboottest.entity.vo.QSysDepartment;
import org.swust.springboottest.mapper.SysDepartmentMapper;
import org.swust.springboottest.service.ISysDepartmentService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author hurenjie
 * @since 2024-12-25
 */
@Service
public class SysDepartmentServiceImpl extends ServiceImpl<SysDepartmentMapper, SysDepartment> implements ISysDepartmentService {


    @Override
    public IPage<SysDepartmentDto> pageDept(Page page, QSysDepartment qSysDepartment) {
        return baseMapper.pageDept(page, qSysDepartment);
    }

    @Override
    public Object getDeptTree() {
        List<SysDepartmentTree> departments = buildDeptTree(baseMapper.selectList(null));
        Map<Long, SysDepartmentTree> deptMap = new HashMap<>();
        for (SysDepartmentTree dept : departments) {
            deptMap.put(dept.getDeptId().longValue(), dept);
        }
        List<SysDepartmentTree> deptTree = new ArrayList<>();
        for (SysDepartmentTree dept : departments) {

            if (dept.getParentId() == null || dept.getParentId() == 0 || dept.getDeptId().longValue() == dept.getParentId()) {
                deptTree.add(dept);
            } else {
                SysDepartmentTree parent = deptMap.get(dept.getParentId());
                if (parent != null) {
                    if (parent.getChildren() == null) {
                        parent.setChildren(new ArrayList<>());
                    }
                    parent.getChildren().add(dept);
                }
            }
        }
        return deptTree;
    }

    private List<SysDepartmentTree> buildDeptTree(List<SysDepartment> departments) {
        List<SysDepartmentTree> departmentTrees = new ArrayList<>();
        for (SysDepartment department : departments) {
            SysDepartmentTree departmentTree = new SysDepartmentTree();
            departmentTree.setDeptId(department.getDeptId());
            departmentTree.setName(department.getName());
            departmentTree.setSort(department.getSort());
            departmentTree.setParentId(department.getParentId());
            departmentTree.setEmail(department.getEmail());
            departmentTree.setLeaderUserId(department.getLeaderUserId());
            departmentTree.setPhone(department.getPhone());
            departmentTree.setNumber(department.getNumber());
            departmentTree.setDelFlag(department.getDelFlag());
            departmentTrees.add(departmentTree);
        }
        return departmentTrees;
    }
}
