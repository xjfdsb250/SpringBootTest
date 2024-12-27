package org.swust.springboottest.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class CountDept {
    @TableField("dept_name")
    private String deptName;
    @TableField("dept_id")
    private Integer deptId;
    @TableField("count")
    private Integer count;
}
