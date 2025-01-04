package org.swust.springboottest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.swust.springboottest.dto.CountDept;
import org.swust.springboottest.dto.SysUserDto;
import org.swust.springboottest.entity.SysUser;
import org.swust.springboottest.entity.vo.QSysUser;

import java.util.List;

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

    @Update("update sys_user set role_id = #{roleId} where user_id = #{userId}")
    int updateRoleById(SysUser user);

    IPage<SysUserDto> pageUser(IPage page, @Param("param") QSysUser qSysUser);

    List<CountDept> countNumByDeptId();

    @Update("update sys_user set password = #{password} where user_id = #{userId}")
    int resetPassword(Integer userId, String password);

    @Select("select count(*) from sys_user where name = #{name}")
    int checkUserExist(String name);

    @Update("update sys_user set password = #{newPassword} where name = #{name}")
    int forgetPassword(String name, String newPassword);
}