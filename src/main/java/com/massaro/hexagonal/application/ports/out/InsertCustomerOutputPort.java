package com.massaro.hexagonal.application.ports.out;

import com.massaro.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {
    void insert(Customer customer);
}
