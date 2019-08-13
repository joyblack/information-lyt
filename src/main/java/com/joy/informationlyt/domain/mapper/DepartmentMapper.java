package com.joy.informationlyt.domain.mapper;


import com.joy.informationlyt.domain.entity.Department;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface DepartmentMapper extends Mapper<Department> {
    /**
     * 根据父节点ID以及名称获取记录信息
     */
    Department getDepartmentByParentIdAndName(@Param("parentId") Long parentId, @Param("name") String name);
}