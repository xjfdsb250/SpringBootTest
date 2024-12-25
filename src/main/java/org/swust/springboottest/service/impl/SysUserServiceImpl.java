package org.swust.springboottest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.swust.springboottest.entity.R;
import org.swust.springboottest.entity.SysUser;
import org.swust.springboottest.mapper.SysUserMapper;
import org.swust.springboottest.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @since 2024-12-24
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Override
    public boolean updateName(SysUser user) {
        return baseMapper.updateName(user) > 0;
    }
}