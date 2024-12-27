package org.swust.springboottest.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.swust.springboottest.dto.SysUserDto;
import org.swust.springboottest.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author hurenjie
 * @since 2024-12-24
 */
public interface ISysUserService extends IService<SysUser> {
    boolean updateName(SysUser user);

    @Override
    boolean save(SysUser entity);

    @Override
    boolean removeById(Serializable id);

    //    IPage<SysUserDto> pageUser(Page page, SysUser qSysUser);
}
