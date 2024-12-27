package org.swust.springboottest.entity.vo;

import lombok.Data;

@Data
public class QSysUser {
    /**
     * 用户角色id
     */
    private Integer roleId;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 用户年龄
     */
    private Integer age;
    /**
     * 用户性别
     */
    private Byte sex;

    /**
     * 用户部门Id
     */
    private Integer deptId;
}
