package com.danielev86.customermicro.service.converter;

import com.danielev86.customermicro.controller.dto.AddressDTO;
import com.danielev86.customermicro.controller.dto.CustomerDTO;
import com.danielev86.customermicro.repository.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class CustomerDTOConverter implements Converter<Customer, CustomerDTO> {

    @Autowired
    @Qualifier("conversionService")
    private ConversionService converter;

    @Override
    public CustomerDTO convert(Customer source) {
        CustomerDTO target = new CustomerDTO();
        target.setId(source.getCustomerId());
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setActive(source.getActive());
        target.setEmail(source.getEmail());
        target.setAddress(converter.convert(source.getAddress(), AddressDTO.class));
        return target;
    }

    public ConversionService getConverter() {
        return converter;
    }

    public void setConverter(ConversionService converter) {
        this.converter = converter;
    }
}
