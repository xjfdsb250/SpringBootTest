package org.swust.springboottest.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;
import org.swust.springboottest.entity.SysUser;

@Setter
@Getter
public class SysUserDto extends SysUser {
    /**
     * 部门名称
     */
    @TableField("dept_name")
    private String deptName;
    /**
     * 角色名称
     */
    @TableField("role_name")
    private String roleName;
}
