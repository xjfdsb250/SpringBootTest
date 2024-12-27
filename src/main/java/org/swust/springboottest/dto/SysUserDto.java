package org.swust.springboottest.dto;

import org.swust.springboottest.entity.SysUser;
import lombok.Data;

@Data
public class SysUserDto extends SysUser {
    private String deptName;
    private String roleName;
}
