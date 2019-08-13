package com.joy.informationlyt.module.department.service;

import com.joy.informationlyt.constant.SystemConstant;
import com.joy.informationlyt.domain.entity.Department;
import com.joy.informationlyt.domain.mapper.DepartmentMapper;
import com.joy.informationlyt.module.common.result.JoyResult;
import com.joy.informationlyt.module.common.result.Notice;
import com.joy.informationlyt.utils.JoyBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public JoyResult add(Department department) {
        // check parent dept info.
        if(!department.getParentId().equals(SystemConstant.TOP_NODE_ID)){
            Department parent = departmentMapper.selectByPrimaryKey(department.getParentId());
            if(parent == null){
                return JoyResult.buildFailedResult(Notice.DEPARTMENT_PARENT_NOT_EXIST);
            }
        }
        // check same name on common level.
        Department checkDepartment = departmentMapper.getDepartmentByParentIdAndName(department.getParentId(), department.getName());
        if(checkDepartment != null){
            return JoyResult.buildFailedResult(Notice.DEPARTMENT_NAME_HAS_EXIST);
        }
        // insert department information.
        departmentMapper.insertSelective(department);
        return JoyResult.buildSuccessResultWithData(department);
    }

    public JoyResult update(Department department) {
        // 获取部门信息
        Department oldDept = departmentMapper.selectByPrimaryKey(department.getId());
        if(oldDept == null){
            return JoyResult.buildFailedResult(Notice.DEPARTMENT_NOT_EXIST);
        }
        // check parent dept info.
        if(!department.getParentId().equals(SystemConstant.TOP_NODE_ID)){
            Department parent = departmentMapper.selectByPrimaryKey(department.getParentId());
            if(parent == null){
                return JoyResult.buildFailedResult(Notice.DEPARTMENT_PARENT_NOT_EXIST);
            }
        }
        // 检查是否有重名部门
        Department checkDepartment = departmentMapper.getDepartmentByParentIdAndName(department.getParentId(), department.getName());
        if(checkDepartment != null && !checkDepartment.getId().equals(department.getId())){
            return JoyResult.buildFailedResult(Notice.DEPARTMENT_NAME_HAS_EXIST);
        }
        // 将数据库的数据对应拷贝到目标对象的空值属性上，其余的保持目标属性的不变。
        JoyBeanUtil.copyPropertiesIgnoreTargetNotNullProperties(oldDept, department);
        departmentMapper.updateByPrimaryKeySelective(department);
        return JoyResult.buildSuccessResultWithData(department);
    }

    public JoyResult delete(Long id) {
        // 获取部门信息
        Department oldDept = departmentMapper.selectByPrimaryKey(id);
        if(oldDept == null){
            return JoyResult.buildFailedResult(Notice.DEPARTMENT_NOT_EXIST);
        }
        Department deleteOrg = new Department();
        deleteOrg.setId(oldDept.getId());
        deleteOrg.setIsDelete(true);
        departmentMapper.updateByPrimaryKeySelective(deleteOrg);
        return JoyResult.buildSuccessResult("删除成功");
    }
}
