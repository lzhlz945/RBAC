package com.zhang.zc.interceptor;

import com.zhang.zc.bean.Permission;
import com.zhang.zc.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PermissionInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private PermissionService permissionService;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        //用户的请求地址
        String uri = httpServletRequest.getRequestURI();
        String servletPath = httpServletRequest.getServletPath();
        System.out.println(servletPath+":122211");
        System.out.println(uri);
        String contextPath = httpServletRequest.getContextPath();
        List<Permission> allPermissions = permissionService.queryPermissionMenu2();
        Set<String> allSet=new HashSet<>();
        Map<String,String[]> parameterMap = httpServletRequest.getParameterMap();
        StringBuilder builder=new StringBuilder("?");
        for (String s : parameterMap.keySet()) {
            builder.append(s);
            builder.append("=");
            builder.append(parameterMap.get(s)[0]);
            builder.append("&");
        }

        System.out.println(servletPath+builder);

        builder.deleteCharAt(builder.length()-1);
        for (Permission allPermission : allPermissions) {
            if(allPermission.getUrl() != null || !"".equals(allPermission.getUrl())){

            allSet.add(contextPath+allPermission.getUrl());
            }
        }
        Set<String> userSet = (Set<String>) session.getAttribute("userPermission");
        //获取权限的url
       if(allSet.contains(uri)){
           //验证权限地址
           if(userSet.contains(uri)){
               return true;
           }else {
               httpServletResponse.sendRedirect(contextPath+"/error");
               return false;
           }
       }


        return false;
    }

}
