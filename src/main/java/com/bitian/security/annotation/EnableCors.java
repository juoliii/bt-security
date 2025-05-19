package com.bitian.security.annotation;

import com.bitian.security.config.CorsConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启跨域支持
 * @author admin
 */
@Documented
@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({CorsConfig.class})
public @interface EnableCors {
}
