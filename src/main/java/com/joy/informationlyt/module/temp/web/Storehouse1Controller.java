package com.joy.informationlyt.module.temp.web;

import com.joy.informationlyt.domain.entity.Storehouse;
import com.joy.informationlyt.module.common.result.JoyResult;
import com.joy.informationlyt.module.common.result.Notice;
import com.joy.informationlyt.module.common.web.request.IdRequest;
import com.joy.informationlyt.module.temp.service.StorehouseService1;
import com.joy.informationlyt.module.temp.web.req.UpdateStoreHouseReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("temp")
public class Storehouse1Controller {

    @Autowired
    private StorehouseService1 storehouseService;

    /**
     * 用户添加
     */
    @PostMapping(
            value = "/add",
            produces = {"application/json;charset=UTF-8"})
    public JoyResult add(@RequestBody @Valid Storehouse storehouse, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JoyResult.buildFailedResult(Notice.REQUEST_PARAMETER_IS_ERROR, bindingResult.getFieldError().getDefaultMessage());
        } else {
            // copy
            return storehouseService.add(storehouse);
        }
    }

    /**
     * 更新
     */
    @PostMapping(
            value = "/update",
            produces = {"application/json;charset=UTF-8"})
    public JoyResult update(@RequestBody @Valid UpdateStoreHouseReq updateUserReq, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JoyResult.buildFailedResult(Notice.REQUEST_PARAMETER_IS_ERROR, bindingResult.getFieldError().getDefaultMessage());
        } else {
            // copy
            return storehouseService.update(updateUserReq);
        }
    }

    /**
     * 删除
     */
    @PostMapping(
            value = "/delete",
            produces = {"application/json;charset=UTF-8"})
    public JoyResult update(@RequestBody @Valid IdRequest idRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JoyResult.buildFailedResult(Notice.REQUEST_PARAMETER_IS_ERROR, bindingResult.getFieldError().getDefaultMessage());
        } else {
            // copy
            return storehouseService.delete(idRequest.getId());
        }
    }

}
