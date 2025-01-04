package org.swust.springboottest.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.swust.springboottest.dto.SysDepartmentDto;
import org.swust.springboottest.dto.SysUserDto;
import org.swust.springboottest.entity.SysDepartment;
import com.baomidou.mybatisplus.extension.service.IService;
import org.swust.springboottest.entity.vo.QSysDepartment;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author hurenjie
 * @since 2024-12-25
 */
public interface ISysDepartmentService extends IService<SysDepartment> {

    IPage<SysDepartmentDto> pageDept(Page page, QSysDepartment qSysDepartment);

    Object getDeptTree();
}
