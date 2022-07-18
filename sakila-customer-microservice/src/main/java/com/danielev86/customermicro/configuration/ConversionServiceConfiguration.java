package com.danielev86.customermicro.configuration;

import com.danielev86.customermicro.service.converter.AddressDTOConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ConversionServiceConfiguration {

    @Bean
    public ConversionService conversionService() {
        MyConversionServiceFactoryBean bean = new MyConversionServiceFactoryBean();
        bean.setConverters(getConverter());
        bean.afterPropertiesSet();
        return bean.getObject();
    }

    private Set<Converter> getConverter(){
        Set<Converter> converters = new HashSet<>();
        converters.add(new AddressDTOConverter());
        return converters;
    }

}
