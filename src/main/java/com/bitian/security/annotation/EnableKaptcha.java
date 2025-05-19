package com.bitian.security.annotation;

import com.bitian.security.config.KaptchaConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启验证码配置
 * @author admin
 */
@Documented
@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({KaptchaConfig.class})
public @interface EnableKaptcha {
}
