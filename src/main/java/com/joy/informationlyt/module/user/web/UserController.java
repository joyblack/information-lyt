package com.joy.informationlyt.module.user.web;

import com.joy.informationlyt.domain.entity.Department;
import com.joy.informationlyt.module.common.result.JoyResult;
import com.joy.informationlyt.domain.entity.User;
import com.joy.informationlyt.module.common.result.Notice;
import com.joy.informationlyt.module.common.web.request.BasePageRequest;
import com.joy.informationlyt.module.common.web.request.IdRequest;
import com.joy.informationlyt.module.user.service.UserService;
import com.joy.informationlyt.module.user.web.req.UpdateUserReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * test
     */
    @RequestMapping(
            value = "test")
    public JoyResult test(@RequestBody @Valid User user, BindingResult bindingResult) {
        return userService.test();
    }


    /**
     * 用户添加
     */
    @PostMapping(
            value = "add",
            produces = {"application/json;charset=UTF-8"})
    public JoyResult add(@RequestBody @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JoyResult.buildFailedResult(Notice.REQUEST_PARAMETER_IS_ERROR, bindingResult.getFieldError().getDefaultMessage());
        } else {
            // copy
            return userService.add(user);
        }
    }

    /**
     * 更新
     */
    @PostMapping(
            value = "update",
            produces = {"application/json;charset=UTF-8"})
    public JoyResult update(@RequestBody @Valid UpdateUserReq updateUserReq, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JoyResult.buildFailedResult(Notice.REQUEST_PARAMETER_IS_ERROR, bindingResult.getFieldError().getDefaultMessage());
        } else {
            // copy
            return userService.update(updateUserReq);
        }
    }

    /**
     * 删除
     */
    @PostMapping(
            value = "delete",
            produces = {"application/json;charset=UTF-8"})
    public JoyResult update(@RequestBody @Valid IdRequest idRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JoyResult.buildFailedResult(Notice.REQUEST_PARAMETER_IS_ERROR, bindingResult.getFieldError().getDefaultMessage());
        } else {
            // copy
            return userService.delete(idRequest.getId());
        }
    }

    /**
     * 删除
     */
    @RequestMapping(
            value = "getList",
            produces = {"application/json;charset=UTF-8"})
    public JoyResult update(@RequestBody @Valid BasePageRequest pageRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JoyResult.buildFailedResult(Notice.REQUEST_PARAMETER_IS_ERROR, bindingResult.getFieldError().getDefaultMessage());
        } else {
            // copy
            return userService.getList(pageRequest);
        }
    }
}
