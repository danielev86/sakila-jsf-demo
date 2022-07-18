package com.danielev86.customermicro.configuration;

import com.danielev86.customermicro.service.converter.AddressDTOConverter;
import com.danielev86.customermicro.service.converter.CustomerDTOConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.ConverterRegistry;
import org.springframework.core.convert.converter.Converter;


import java.util.HashSet;
import java.util.Set;
@Configuration
public class MyConversionServiceFactoryBean extends ConversionServiceFactoryBean {

    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
        ConversionService conversionService = getObject();
        ConverterRegistry registry = (ConverterRegistry) conversionService;
        registry.addConverter(getCustomerDTOConverter(conversionService));
    }

    public CustomerDTOConverter getCustomerDTOConverter(ConversionService conversionService){
        CustomerDTOConverter converter = new CustomerDTOConverter();
        converter.setConverter(conversionService);
        return converter;
    }
}
