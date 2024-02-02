package kg.bakai.eo.controllers;

import kg.bakai.eo.dto.AllDto;
import kg.bakai.eo.models.Customer;
import kg.bakai.eo.services.CustomerService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<String> saveCustomer(@Valid @RequestBody AllDto customerDTO) {
        customerService.saveCustomerData(customerDTO);
        return ResponseEntity.ok("Customer saved successfully");
    }

    @GetMapping("/findByIdentificationNumber/{identificationNumber}")
    public ResponseEntity<Customer> findByIdentificationNumber(@PathVariable String identificationNumber) {
        Customer customer = customerService.findByIdentificationNumber(identificationNumber);

        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

    @GetMapping("/findByFullName")
    public ResponseEntity<Customer> findByFullName(
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String customerName,
            @RequestParam(required = false) String otchestvo) {

        Customer customer = customerService.findByFullName(surname, customerName, otchestvo);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
