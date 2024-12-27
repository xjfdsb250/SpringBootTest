package org.swust.springboottest.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author hurenjie
 * @since 2024-12-25
 */
@Getter
@Setter
@TableName("sys_department")
public class SysDepartment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门id
     */
    @TableId(value = "dept_id", type = IdType.AUTO)
    private Integer deptId ;

    /**
     * 部门名称
     */
    @TableField("name")
    @NotNull
    private String name;

    /**
     * 部分优先级
     */
    @TableField("sort")
    private Integer sort = 0;

    /**
     * 父部门id
     */
    @TableField("parent_id")
    @NotNull
    private Long parentId;

    /**
     * 电子邮箱
     */
    @TableField("email")
    private String email;

    /**
     * leader的id
     */
    @TableField("leader_user_id")
    @NotNull
    private Long leaderUserId;

    /**
     * 部门电话
     */
    @TableField("phone")
    private String phone;

    /**
     * 部门人数
     */
    @TableField("number")
    private Integer number = 0;

    /**
     * 删除标识
     */
    @TableField("del_flag")
    @TableLogic
    private Integer delFlag;
}
