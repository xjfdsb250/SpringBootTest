package org.swust.springboottest.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.swust.springboottest.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author hurenjie
 * @since 2024-12-27
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

}
