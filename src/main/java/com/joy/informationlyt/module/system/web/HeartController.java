package com.joy.informationlyt.module.system.web;

import com.joy.informationlyt.module.common.result.JoyResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("system-heart")
public class HeartController {
    @RequestMapping("ping")
    public JoyResult ping(HttpServletRequest request){
        return JoyResult.buildSuccessResult("pong!");
    }

}