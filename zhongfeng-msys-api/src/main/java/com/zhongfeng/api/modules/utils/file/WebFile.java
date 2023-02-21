package com.zhongfeng.api.modules.utils.file;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@WebFilter(filterName = "webfile",urlPatterns = "/*")//webfilter注解,里面注明外检的名字,注明拦截的请求
@Slf4j
public class WebFile implements Filter {

    public static final AntPathMatcher annotation=new AntPathMatcher();

    /**
     * url过滤
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //向下转型
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //业务逻辑1,得到url,
        //看看url是否需要处理
        String requestURI = request.getRequestURI();
        //设定一个不需要处理的url数组
        String[] urls=new String[]{
                "/page/login/**",
                "/img/**",
                "/js/**",
                "/styles/**",
                "/favicon.ico",
                "/api/user/login",
                "/doc.html"
        };
        //判断是否匹配
        Boolean aBoolean = urlPatterns(urls, requestURI);
        if(aBoolean){
            //如果通过就方形
            filterChain.doFilter(request, response);
            return;
        }
        //判断是否登录
        //得到session对象
        if(request.getSession().getAttribute("userId")!=null) {
            filterChain.doFilter(request, response);
            return;
        }
        //重定向到登录页面
        response.sendRedirect("/page/login/login.html");
        return;
    }

    /**
     * 匹配url的方法
     * @param urls
     * @param url
     * @return
     */
    public Boolean urlPatterns(String[] urls,String url) {
        for (String url1:urls) {
            boolean match = annotation.match(url1, url);
            if(match){
                return true;
            }
        }
        return false;
    }

}