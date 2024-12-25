package org.swust.springboottest.mapper;

import lombok.AllArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.swust.springboottest.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author hurenjie
 * @since 2024-12-24
 */

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    @Update("update sys_user set name = #{name} where user_id = #{userId}")
    int updateName(SysUser user);
}

