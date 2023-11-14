package com.system.interceptor;

import com.alibaba.fastjson2.JSON;
import com.system.common.utils.JwtUtil;
import com.system.common.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author : xzy
 * Date 2023/9/28 10:10
 */
@Component
@Slf4j
public class JwtValidateInterceptor implements HandlerInterceptor {
    @Autowired
    JwtUtil jwtUtil;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("X-Token");
        log.debug(request.getRequestURI() +"需要验证："+token);
        if (request.getMethod().equals("OPTIONS")){
            return true;
        }//跨域环境下，前端发送一个真正请求前会发送一次预检（opinion）请求，预检请求是不携带token的。记得放行预检请求即可。
        if (token != null){
            try {
                jwtUtil.parseToken(token);
                log.debug(request.getRequestURI() +"验证通过");
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        log.debug(request.getRequestURI() +"验证失败禁止访问");
        response.setContentType("application/json;charset=utf-8");
        Result<Object> result = Result.fail(20003, "jwt无效请重新登录");
        response.getWriter().write(JSON.toJSONString(result));
        return false;//拦截
    }
}
