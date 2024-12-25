package org.swust.springboottest.service;

import org.swust.springboottest.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
