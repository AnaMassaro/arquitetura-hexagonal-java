package com.massaro.hexagonal.adapters.in.controller;

import com.massaro.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.massaro.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.massaro.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.massaro.hexagonal.application.core.domain.Customer;
import com.massaro.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.massaro.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.massaro.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.massaro.hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    // @RequestBody converte o JSON do corpo da requisição para o objeto CustomerRequest
    // @Valid ativa as validações configuradas no CustomerRequest (ex: @NotNull, @Size, etc.)
    @PostMapping
    public ResponseEntity<Map<String, String>> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        var customerId = insertCustomerInputPort.insert(customer, customerRequest.getZipCode());

        var response = Map.of("customerId", customerId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        var customer =  findCustomerByIdInputPort.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id, @Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
