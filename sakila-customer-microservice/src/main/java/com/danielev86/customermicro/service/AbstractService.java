package com.danielev86.customermicro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;


public abstract class AbstractService {

    @Autowired
    private ConversionService converter;

    public ConversionService getConverter() {
        return converter;
    }

    public void setConverter(ConversionService converter) {
        this.converter = converter;
    }
}
