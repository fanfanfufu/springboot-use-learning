package cn.fuqi.springbootuselearning.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author FuQi
 * @date 2021/11/24 22:55
 * @description
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * 统一返回数据格式封装处理String类型的数据-方法二
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(0, new MappingJackson2HttpMessageConverter());
        converters.add(new StringHttpMessageConverter());
    }
}
