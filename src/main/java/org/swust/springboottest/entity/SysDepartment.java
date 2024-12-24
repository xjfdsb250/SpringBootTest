package org.swust.springboottest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author hurenjie
 * @since 2024-12-24
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
    private Integer deptId;

    /**
     * 部门名称
     */
    @TableField("name")
    private String name;

    /**
     * 部分优先级
     */
    @TableField("sort")
    private Integer sort;

    /**
     * 父部门id
     */
    @TableField("parent_id")
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
    private Long leaderUserId;

    /**
     * 部门电话
     */
    @TableField("phone")
    private String phone;
}
