package com.zll.dijiag.config.json;

import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@Configuration
public class FastJsonConfiguration {
	
	@Bean  
	public HttpMessageConverters fastJsonHttpMessageConverters() {  
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();  
		FastJsonConfig fastJsonConfig = new FastJsonConfig();  
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);  
		fastConverter.setFastJsonConfig(fastJsonConfig);  
		HttpMessageConverter<?> converter = fastConverter;  
		return new HttpMessageConverters(converter);
	}

}
