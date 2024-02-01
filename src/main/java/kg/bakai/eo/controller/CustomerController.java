package kg.bakai.eo.controller;

import kg.bakai.eo.dto.AllDto;
import kg.bakai.eo.models.Customer;
import kg.bakai.eo.service.CustomerService;
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
        try {
            customerService.saveCustomerData(customerDTO);
            return ResponseEntity.ok("Customer saved successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving customer");
        }
    }

    @GetMapping("/findByIdentificationNumber/{identificationNumber}")
    public ResponseEntity<Customer> findByIdentificationNumber(@PathVariable String identificationNumber) {
        try {
            Customer customer = customerService.findByIdentificationNumber(identificationNumber);
            if (customer != null) {
                return ResponseEntity.ok(customer);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/findByFullName")
    public ResponseEntity<Customer> findByFullName(
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String customerName,
            @RequestParam(required = false) String otchestvo) {
        try {
            Customer customer = customerService.findByFullName(surname, customerName, otchestvo);
            if (customer != null) {
                return ResponseEntity.ok(customer);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
