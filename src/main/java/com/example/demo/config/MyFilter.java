package com.example.demo.config;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req1 = (HttpServletRequest) req;
        System.out.println("this is myFilter "+req1.getRequestURI());





        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
