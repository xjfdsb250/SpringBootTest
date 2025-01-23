package org.swust.springboottest.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;
import org.swust.springboottest.entity.SysDepartment;

import java.util.List;

@Getter
@Setter
public class SysDepartmentTree extends SysDepartment {
    /**
     * 子部门
     */
    @TableField(exist = false)
    private List<SysDepartment> children;
}
