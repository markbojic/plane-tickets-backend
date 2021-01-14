package com.raf.nwp.planetickets.filters;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(1)
public class BasicFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Basic Filter");
        System.out.println("Local port: " + servletRequest.getLocalPort());
        System.out.println("Server name: " + servletRequest.getServerName());
        System.out.println("Protocol: " + servletRequest.getProtocol());
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        System.out.println("Method: " + httpServletRequest.getMethod());
        System.out.println("Request URI: " + httpServletRequest.getRequestURI());
        System.out.println("...................................................................................................................................");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
