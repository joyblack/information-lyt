package com.joy.informationlyt.module.account.web;

import com.joy.informationlyt.module.account.service.AccountService;
import com.joy.informationlyt.module.common.result.JoyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountService accountService;
    /**
     * 获取当前登录的用户信息
     * @return
     */
    @RequestMapping("/getMyInformation")
    public JoyResult getMyInformation(HttpServletRequest request) {
        return accountService.getMyInformation(request);
    }
}
