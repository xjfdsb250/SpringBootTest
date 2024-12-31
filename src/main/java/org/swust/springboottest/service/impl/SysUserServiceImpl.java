package org.swust.springboottest.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.swust.springboottest.dto.CountDept;
import org.swust.springboottest.dto.SysUserDto;
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

    private static final PasswordEncoder ENCODER = new BCryptPasswordEncoder();


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
    public Integer addUser(SysUser entity) {
        boolean check = checkUserExist(entity.getName());
        if (check) {
            return 0;
        }
        boolean result = super.save(entity);
        if (result) {
            sysDepartmentMapper.editNumber(1, entity.getDeptId());
            return 1;
        }
        return 2;

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

    @Override
    public boolean resetPassword(Integer userId) {
        String password = ENCODER.encode("123456");
        return baseMapper.resetPassword(userId, password) > 0;
    }

    @Override
    public SysUser getByName(String name) {
        return null;
    }

    @Override
    public boolean checkUserExist(String name) {
        return baseMapper.checkUserExist(name) > 0;
    }

}