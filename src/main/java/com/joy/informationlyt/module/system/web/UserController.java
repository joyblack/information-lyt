package com.joy.informationlyt.module.system.web;

import com.joy.informationlyt.module.common.result.JoyResult;
import com.joy.informationlyt.domain.entity.User;
import com.joy.informationlyt.module.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("system-user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param bindingResult
     * @return
     */
    @PostMapping(
            value = "/register",
            produces = {"application/json;charset=UTF-8"})
    public JoyResult register(@RequestBody @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JoyResult.buildFailedResult(bindingResult.getFieldError().getDefaultMessage());
        } else {
            // copy
            return userService.register(user);
        }
    }

}
