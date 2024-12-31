package org.swust.springboottest.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.swust.springboottest.dto.SysDepartmentDto;
import org.swust.springboottest.entity.SysDepartment;
import org.swust.springboottest.entity.vo.QSysDepartment;
import org.swust.springboottest.mapper.SysDepartmentMapper;
import org.swust.springboottest.service.ISysDepartmentService;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author hurenjie
 * @since 2024-12-25
 */
@Service
public class SysDepartmentServiceImpl extends ServiceImpl<SysDepartmentMapper, SysDepartment> implements ISysDepartmentService {


    @Override
    public IPage<SysDepartmentDto> pageDept(Page page, QSysDepartment qSysDepartment) {
        return baseMapper.pageDept(page, qSysDepartment);
    }
}
