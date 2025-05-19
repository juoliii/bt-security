package com.bitian.security.annotation;

import com.bitian.security.config.ThreadPoolConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启线程池配置相关
 * @author admin
 */
@Documented
@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({ThreadPoolConfig.class})
public @interface EnableThreadPool {
}
