package com.bitian.security.annotation;

import com.bitian.security.config.RedisCacheConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启redis缓存
 * 添加缓存：方法上添加以下注解
 * @Cacheable(value = RedisCacheKey.NOTICE_LIST_CACHE,condition = "#form.submit!=null && #form.submit==true")
 * 删除缓存：方法上添加以下注解
 * @CacheEvict(value = RedisCacheKey.NOTICE_LIST_CACHE,allEntries = true)
 * @author admin
 */
@Documented
@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({RedisCacheConfig.class})
public @interface EnableRedisCache {
}
