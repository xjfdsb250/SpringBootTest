package org.swust.springboottest.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.swust.springboottest.dto.SysUserDto;
import org.swust.springboottest.dto.CountDept;
import org.swust.springboottest.entity.SysUser;
import org.swust.springboottest.entity.vo.QSysUser;
import org.swust.springboottest.mapper.SysDepartmentMapper;
import org.swust.springboottest.mapper.SysUserMapper;
import org.swust.springboottest.service.ISysUserService;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @since 2024-12-24
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {


    @Autowired
    private SysDepartmentMapper sysDepartmentMapper;

    @Override
    public boolean updateName(SysUser user) {
        return baseMapper.updateName(user) > 0;
    }

    @Override
    public boolean updateRoleById(SysUser user) {
        return baseMapper.updateRoleById(user) > 0;
    }

    @Override
    @Transactional
    public boolean save(SysUser entity) {
        boolean result = super.save(entity);
        if (result) {
            sysDepartmentMapper.editNumber(1, entity.getDeptId());
        }
        return result;
    }

    @Override
    @Transactional
    public boolean removeById(Serializable id) {
        SysUser user = baseMapper.selectById(id);
        boolean result = super.removeById(id);
        if (result) {
            sysDepartmentMapper.editNumber(-1, user.getDeptId());
        }
        return result;
    }

    @Override
    public IPage<SysUserDto> pageUser(Page page, QSysUser qSysUser) {
        return baseMapper.pageUser(page, qSysUser);
    }

    @Override
    public List<CountDept> countNumByDeptId() {
        return baseMapper.countNumByDeptId();
    }

}