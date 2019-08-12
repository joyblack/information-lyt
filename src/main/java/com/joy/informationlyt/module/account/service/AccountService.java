package com.joy.informationlyt.module.account.service;

import com.joy.informationlyt.module.common.result.JoyResult;
import com.joy.informationlyt.utils.jwt.TokenUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class AccountService {
    public JoyResult getMyInformation(HttpServletRequest request) {
        return JoyResult.buildSuccessResultWithData(TokenUtil.getUser(request));
    }
}
