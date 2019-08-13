package com.joy.informationlyt.module.temp.service;

import com.joy.informationlyt.domain.entity.Storehouse;
import com.joy.informationlyt.domain.mapper.StorehouseMapper;
import com.joy.informationlyt.module.common.result.JoyResult;
import com.joy.informationlyt.module.common.result.Notice;
import com.joy.informationlyt.module.temp.web.req.UpdateStoreHouseReq;
import com.joy.informationlyt.utils.JoyBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StorehouseService1{
    @Autowired
    private StorehouseMapper storehouseMapper;

    public JoyResult add(Storehouse storehouse) {
        storehouseMapper.insertSelective(storehouse);
        return JoyResult.buildSuccessResultWithData(storehouse);
    }

    public JoyResult update(UpdateStoreHouseReq updateUserReq) {
        Storehouse storehouseOld = storehouseMapper.selectByPrimaryKey(updateUserReq.getId());
        if(storehouseOld == null){
            return JoyResult.buildFailedResult(Notice.STOREHOUSE_NOT_EXIST);
        }
        // 拷贝属性到oldUser之上
        JoyBeanUtil.copyPropertiesIgnoreSourceNullProperties(updateUserReq, storehouseOld);
        // 保存数据
        storehouseOld.setUpdateTime(new Date());
        storehouseMapper.updateByPrimaryKeySelective(storehouseOld);
        return JoyResult.buildSuccessResultWithData(storehouseOld);
    }

    public JoyResult delete(Long id) {
        // 获取部门信息
        Storehouse storehouse = storehouseMapper.selectByPrimaryKey(id);
        if(storehouse == null){
            return JoyResult.buildFailedResult(Notice.STOREHOUSE_NOT_EXIST);
        }
        Storehouse delete = new Storehouse();
        delete.setId(storehouse.getId());
        delete.setUpdateTime(new Date());
        delete.setIsDelete(true);
        storehouseMapper.updateByPrimaryKeySelective(delete);
        return JoyResult.buildSuccessResult("删除成功");
    }
}
