package com.danielev86.customermicro.service.converter;

import com.danielev86.customermicro.controller.dto.AddressDTO;
import com.danielev86.customermicro.repository.model.Address;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

public class AddressDTOConverter implements Converter<Address, AddressDTO> {
    @Override
    public AddressDTO convert(Address source) {
        AddressDTO target = new AddressDTO();
        target.setId(source.getAddressId());
        target.setAddress(source.getAddress());
        target.setAddress2(source.getAddress2());
        target.setDistrict(source.getDistrict());
        target.setPostalCode(source.getPostalCode());
        return target;
    }
}
