package com.massaro.hexagonal.application.ports.in;

import com.massaro.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {
    void update(Customer customer, String zipCode);
}
