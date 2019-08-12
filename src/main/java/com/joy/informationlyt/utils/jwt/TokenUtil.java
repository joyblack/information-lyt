package com.joy.informationlyt.utils.jwt;

import cn.hutool.json.JSONUtil;
import com.joy.informationlyt.exception.JoyException;
import com.joy.informationlyt.domain.entity.User;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 13562
 */
public class TokenUtil {

    private static final Logger logger = LoggerFactory.getLogger(TokenUtil.class);

    /**
     * 获取登陆用户信息
     *
     * @param request
     * @return
     */
    public static User getUser(HttpServletRequest request) {
        try {
            Claims claims = (Claims) request.getAttribute(Token.CLAIMS.getName());
            return JSONUtil.toBean(JSONUtil.toJsonStr(claims.get(Token.USER.getName())), User.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new JoyException("无法从token中取得用户信息");
        }
    }

    /**
     * 获取登陆用户id
     *
     * @param request
     * @return
     */
    public static Long getUserId(HttpServletRequest request) {
        try {
            Claims claims = (Claims) request.getAttribute(Token.CLAIMS.getName());
            return JSONUtil.toBean(JSONUtil.toJsonStr(claims.get(Token.USER.getName())), User.class).getId();
        } catch (Exception e) {
            logger.info("无法从token中取得用户信息");
            return null;
        }
    }

}
