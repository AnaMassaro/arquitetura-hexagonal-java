package com.massaro.hexagonal.adapters.out.client.mapper;

import com.massaro.hexagonal.adapters.out.client.response.AddressResponse;
import com.massaro.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring") // <- permite injeção pelo Spring
public interface AddressResponseMapper {

    // Método que converte AddressResponse (DTO) para Address (Domain)
    Address toAddress(AddressResponse addressResponse);

}
