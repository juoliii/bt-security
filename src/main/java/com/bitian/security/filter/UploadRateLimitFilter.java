package com.bitian.security.filter;

import com.bitian.common.web.UploadRateLimitRequestWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author admin
 */
public class UploadRateLimitFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(new UploadRateLimitRequestWrapper((HttpServletRequest) servletRequest,1024*1024), servletResponse);
    }

}
