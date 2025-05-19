package com.bitian.security.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * 验证码配置类
 * @author admin
 */
@Configuration
public class KaptchaConfig {

    @Value("${bt.kaptcha.width:200}")
    private String width;

    @Value("${bt.kaptcha.height:50}")
    private String height;

    @Value("${bt.kaptcha.font-color:black}")
    private String fontColor;

    @Value("${bt.kaptcha.font-size:30}")
    private String fontSize;

    @Value("${bt.kaptcha.char-space:5}")
    private String charSpace;

    @Value("${bt.kaptcha.char-length:4}")
    private String charLength;

    @Bean
    public DefaultKaptcha getDefaultKaptcha(){
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.put("kaptcha.border", "no");
        properties.put("kaptcha.textproducer.font.color", fontColor);
        properties.put("kaptcha.image.width", width);
        properties.put("kaptcha.image.height", height);
        properties.put("kaptcha.textproducer.font.size", fontSize);
        properties.put("kaptcha.session.key", "bt-Kaptcha-verifyCode");
        properties.put("kaptcha.textproducer.char.space", charSpace);
        properties.put("kaptcha.textproducer.char.length", charLength);
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
