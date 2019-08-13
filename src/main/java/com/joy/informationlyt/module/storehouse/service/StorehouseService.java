package com.joy.informationlyt.module.storehouse.service;

import com.joy.informationlyt.domain.entity.Storehouse;
import com.joy.informationlyt.domain.mapper.StorehouseMapper;
import com.joy.informationlyt.module.common.result.JoyResult;
import com.joy.informationlyt.module.common.result.Notice;
import com.joy.informationlyt.module.common.service.BaseService;
import com.joy.informationlyt.module.storehouse.web.req.UpdateStoreHouseReq;
import com.joy.informationlyt.utils.JoyBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StorehouseService extends BaseService<Storehouse> {
    @Autowired
    private StorehouseMapper storehouseMapper;

    public JoyResult add(Storehouse storehouse) {
        // 不允许同名出现
        Storehouse check = storehouseMapper.selectOneByName(storehouse.getName());
        if(check != null){
            return JoyResult.buildFailedResult(Notice.STOREHOUSE_NAME_ALREADY_EXIST);
        }
        // 添加
        insertSelective(storehouse);
        return JoyResult.buildSuccessResultWithData(storehouse);
    }

    public JoyResult update(UpdateStoreHouseReq updateUserReq) {
        Storehouse storehouseOld = storehouseMapper.selectByPrimaryKey(updateUserReq.getId());
        if(storehouseOld == null){
            return JoyResult.buildFailedResult(Notice.STOREHOUSE_NOT_EXIST);
        }
        // 不允许同名仓库出现
        if(updateUserReq.getName() != null){
            Storehouse check = storehouseMapper.selectOneByNameAndIdNot(updateUserReq.getName(), updateUserReq.getId());
            if(check != null){
                return JoyResult.buildFailedResult(Notice.STOREHOUSE_NAME_ALREADY_EXIST);
            }
        }
        JoyBeanUtil.copyPropertiesIgnoreSourceNullProperties(updateUserReq, storehouseOld);
        updateByPrimaryKeySelective(storehouseOld);
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
        delete.setIsDelete(true);
        delete.setUpdateTime(new Date());
        storehouseMapper.updateByPrimaryKeySelective(delete);
        return JoyResult.buildSuccessResult("删除成功");
    }
}
