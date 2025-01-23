package org.swust.springboottest.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.swust.springboottest.entity.SysDepartment;

@Data
public class SysDepartmentDto extends SysDepartment {
    /**
     * 部门领导姓名
     */
    @TableField("leader_name")
    private String leaderName;
}
