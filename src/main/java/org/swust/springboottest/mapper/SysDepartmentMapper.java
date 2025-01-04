package org.swust.springboottest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Getter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.swust.springboottest.dto.SysDepartmentDto;
import org.swust.springboottest.entity.SysDepartment;
import org.swust.springboottest.entity.vo.QSysDepartment;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author hurenjie
 * @since 2024-12-25
 */
@Mapper
public interface SysDepartmentMapper extends BaseMapper<SysDepartment> {
    @Update("update sys_department set number = number + #{type} where dept_id = #{deptId}")
    int editNumber(int type, Long deptId);

    IPage<SysDepartmentDto> pageDept(IPage page, @Param("param") QSysDepartment qSysDepartment);


    Object getDeptTree();
}
