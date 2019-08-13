package com.joy.informationlyt.module.staff.service;

import com.joy.informationlyt.domain.entity.Department;
import com.joy.informationlyt.domain.entity.Position;
import com.joy.informationlyt.domain.entity.Staff;
import com.joy.informationlyt.domain.mapper.DepartmentMapper;
import com.joy.informationlyt.domain.mapper.PositionMapper;
import com.joy.informationlyt.domain.mapper.StaffMapper;
import com.joy.informationlyt.module.common.result.JoyResult;
import com.joy.informationlyt.module.common.result.Notice;
import com.joy.informationlyt.utils.PhoneUtil;
import com.joy.informationlyt.utils.StringUtil;
import com.joy.informationlyt.utils.identity.IdNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StaffService{
    @Autowired
    private StaffMapper staffMapper;

    @Autowired
    private PositionMapper positionMapper;

    @Autowired
    private DepartmentMapper departmentMapper;


    /**
     * 添加员工
     */
    public JoyResult add(Staff staff) {

        /**
         * 校验： 身份证号、手机号、登录名
         */
        if(!IdNumberUtil.isIDNumber(staff.getIdNumber())){
            return JoyResult.buildFailedResult(Notice.IDENTITY_NUMBER_ERROR);
        }

        if(StringUtil.isNotEmpty(staff.getPhone()) && !PhoneUtil.isMobile(staff.getPhone())){
            return JoyResult.buildFailedResult(Notice.PHONE_ERROR);
        }

        /**
         * 检测职位是否存在
         */
        Position position = positionMapper.selectByPrimaryKey(staff.getPositionId());
        if(position == null){
            return JoyResult.buildFailedResult(Notice.POSITION_NOT_EXIST);
        }

        /**
         * 检测部门是否存在
         */
        Department department = departmentMapper.selectByPrimaryKey(staff.getDepartmentId());
        if(department == null){
            return JoyResult.buildFailedResult(Notice.DEPARTMENT_NOT_EXIST);
        }
        // 保存数据
        staffMapper.insertSelective(staff);
        return JoyResult.buildSuccessResultWithData(staff);
    }

    public JoyResult update(Staff staff) {
        Staff oldStaff = staffMapper.selectByPrimaryKey(staff.getId());
        if(oldStaff == null){
            return JoyResult.buildFailedResult(Notice.STAFF_NOT_EXIST);
        }
        oldStaff.setUpdateTime(new Date());
        staffMapper.updateByPrimaryKeySelective(staff);
        return JoyResult.buildSuccessResultWithData(oldStaff);
    }

    public JoyResult delete(Long id) {
        // 获取部门信息
        Staff Staff = staffMapper.selectByPrimaryKey(id);
        if(Staff == null){
            return JoyResult.buildFailedResult(Notice.STAFF_NOT_EXIST);
        }
        Staff delete = new Staff();
        delete.setId(Staff.getId());
        delete.setIsDelete(true);
        delete.setUpdateTime(new Date());
        staffMapper.updateByPrimaryKeySelective(delete);
        return JoyResult.buildSuccessResult("删除成功");
    }

}
