package kg.bakai.eo.service;

import kg.bakai.eo.dto.AddressInfoDTO;
import kg.bakai.eo.dto.CustomerDTO;
import kg.bakai.eo.models.AddressInfo;
import kg.bakai.eo.models.Customer;
import kg.bakai.eo.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;

        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        // Ignore conflicting fields
        modelMapper.typeMap(AddressInfoDTO.class, AddressInfo.class)
                .addMappings(mapper -> mapper.skip(AddressInfo::setId));
    }

    public void saveCustomer(CustomerDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customerRepository.save(customer);
    }
}
