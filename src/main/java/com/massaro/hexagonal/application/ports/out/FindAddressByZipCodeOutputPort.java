package com.massaro.hexagonal.application.ports.out;

import com.massaro.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {
    Address find(String zipCode);
}
