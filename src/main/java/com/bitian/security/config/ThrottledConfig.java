package com.bitian.security.config;

import com.bitian.security.filter.UploadRateLimitFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * 流量控制配置
 * @author admin
 */
public class ThrottledConfig {

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver=new CommonsMultipartResolver();
        resolver.setResolveLazily(true);
        resolver.setMaxUploadSize(1024*1024*1024);
        return resolver;
    }

    @Bean
    public FilterRegistrationBean<UploadRateLimitFilter> uploadRateLimitFilter() {
        FilterRegistrationBean<UploadRateLimitFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new UploadRateLimitFilter());
        registrationBean.addUrlPatterns("/*"); // 设置过滤的 URL
        return registrationBean;
    }

}
