package org.swust.springboottest.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.swust.springboottest.entity.SysDepartment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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

}
