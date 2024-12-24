package org.swust.springboottest.service.impl;

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
 * @author hurenjie
 * @since 2024-12-24
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
