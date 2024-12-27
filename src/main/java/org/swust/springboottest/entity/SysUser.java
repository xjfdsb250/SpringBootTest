package org.swust.springboottest.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author hurenjie
 * @since 2024-12-24
 */
@Data
@TableName("sys_user")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户姓名
     */
    @TableField("name")
    @NotNull
    private String name;

    /**
     * 用户年龄
     */
    @TableField("age")
    @NotNull
    private Integer age;

    /**
     * 用户性别
     */
    @TableField("sex")
    @NotNull
    private Byte sex;

    /**
     * 用户电话号
     */
    @TableField("phone")
    private String phone;

    /**
     * 用户部门
     */
    @TableField("dept_id")
    @NotNull
    private Long deptId;

    /**
     * 用户邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 删除标识
     */
    @TableField("del_flag")
    @TableLogic
    private Integer delFlag;

}
