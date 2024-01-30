package kg.bakai.eo.controller;

import kg.bakai.eo.dto.AllDto;
import kg.bakai.eo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveCustomer(@Valid @RequestBody AllDto customerDto) {
        customerService.saveCustomerData(customerDto);
        return ResponseEntity.ok("Customer saved successfully");
    }
}

