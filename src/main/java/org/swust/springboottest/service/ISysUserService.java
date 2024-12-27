package org.swust.springboottest.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.swust.springboottest.dto.SysUserDto;
import org.swust.springboottest.dto.CountDept;
import org.swust.springboottest.entity.SysUser;
import org.swust.springboottest.entity.vo.QSysUser;

import java.io.Serializable;
import java.util.List;

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

    boolean updateRoleById(SysUser user);

    @Override
    boolean save(SysUser entity);

    @Override
    boolean removeById(Serializable id);

    IPage<SysUserDto> pageUser(Page page, QSysUser qSysUser);

    List<CountDept> countNumByDeptId();

    boolean resetPassword(Integer userId);
}
