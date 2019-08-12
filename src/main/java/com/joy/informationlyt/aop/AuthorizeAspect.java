package com.joy.informationlyt.aop;

import com.joy.informationlyt.exception.JoyException;
import com.joy.informationlyt.config.JwtParamConfig;
import com.joy.informationlyt.module.common.result.JoyResult;
import com.joy.informationlyt.module.common.result.Notice;
import com.joy.informationlyt.utils.jwt.JwtUtil;
import com.joy.informationlyt.utils.jwt.Token;
import io.jsonwebtoken.Claims;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆拦截
 */
//@Aspect
@Component
public class AuthorizeAspect {

    @Autowired
    private JwtParamConfig jwtParamConfig;

    @Pointcut("execution(public * com.joy.informationlyt.module.*.web.*Controller.*(..))"
            + "&&!execution(public * com.joy.informationlyt.module.login.web.LoginController.*(..))"
            + "&&!execution(public * com.joy.informationlyt.module.user.web.UserController.*(..))"
            + "&&!execution(public * com.joy.informationlyt.module.system.web.HeartController.*(..))"
           )
    public void auth() {
    }

    @Before("auth()")
    public void doAuth() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();
        final Object authHeader = request.getHeader(Token.AUTHORIZATION.getName());
        if (authHeader == null) {
            throw new JoyException(JoyResult.buildFailedResult(Notice.USER_NOT_LOGIN));
        }
        final Claims claims = JwtUtil.parseJWT(authHeader.toString(), jwtParamConfig.getBase64Security());
        if (claims == null) {
            throw new JoyException(Notice.USER_NOT_LOGIN);
        }
        request.setAttribute(Token.CLAIMS.getName(), claims);
        response.setHeader(Token.AUTHORIZATION.getName(), JwtUtil.createJWT(claims, jwtParamConfig));
    }
}
