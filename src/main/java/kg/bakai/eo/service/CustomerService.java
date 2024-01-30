package kg.bakai.eo.service;

import jakarta.transaction.Transactional;
import kg.bakai.eo.dto.AddressInfoDto;
import kg.bakai.eo.dto.AllDto;
import kg.bakai.eo.dto.CustomerDto;
import kg.bakai.eo.dto.WorkInformationDto;
import kg.bakai.eo.models.AddressInfo;
import kg.bakai.eo.models.Customer;
import kg.bakai.eo.models.WorkInformation;
import kg.bakai.eo.repository.CustomerRepository;
import kg.bakai.eo.repository.WorkInformationRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    private final WorkInformationRepository workInformationRepository;

    private final ModelMapper modelMapper;


    public CustomerService(CustomerRepository customerRepository, WorkInformationRepository workInformationRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.workInformationRepository = workInformationRepository;
        this.modelMapper = modelMapper;

        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        // Ignore conflicting fields
        modelMapper.typeMap(AddressInfoDto.class, AddressInfo.class)
                .addMappings(mapper -> mapper.skip(AddressInfo::setId));
    }

    @Transactional
    public void saveCustomerData(AllDto customerDto) {
        Customer customer = modelMapper.map(customerDto.customerDto(), Customer.class);
        customerRepository.save(customer);

        saveWorkInformation(customerDto.workInformationDto(), customer);


    }

    private void saveAddressInfo(AddressInfoDto addressInfoDto) {
        if (addressInfoDto != null) {
            AddressInfo addressInfo = modelMapper.map(addressInfoDto, AddressInfo.class);

        }
    }

    private void saveWorkInformation(WorkInformationDto workInformationDto, Customer customer) {
        if (workInformationDto != null) {
            WorkInformation workInformation = modelMapper.map(workInformationDto, WorkInformation.class);
            workInformation.setCustomer(customer); // устанавливаем связь с Customer
            workInformationRepository.save(workInformation);
        }
    }

    private void saveCustomer(CustomerDto customerDto) {
        if (customerDto != null) {

            Customer customer = modelMapper.map(customerDto, Customer.class);
            customerRepository.save(customer);
        }
    }


}
