package com.massaro.hexagonal.adapters.out;

import com.massaro.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.massaro.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.massaro.hexagonal.application.core.domain.Address;
import com.massaro.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // Spring cria e gerencia esse objeto automaticamente
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    @Autowired // Spring injeta automaticamente as dependências
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override // método obrigatório, pois está definido na interface
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
