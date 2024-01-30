package kg.bakai.eo.service;

import jakarta.transaction.Transactional;
import kg.bakai.eo.dto.AddressInfoDto;
import kg.bakai.eo.dto.AllDTO;
import kg.bakai.eo.dto.CustomerDTO;
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
    public void saveCustomerData(AllDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO.getCustomerDTO(), Customer.class);
        customerRepository.save(customer);

        saveWorkInformation(customerDTO.getWorkInformation(), customer);


    }

    private void saveAddressInfo(AddressInfoDto addressInfoDTO) {
        if (addressInfoDTO != null) {
            AddressInfo addressInfo = modelMapper.map(addressInfoDTO, AddressInfo.class);

        }
    }

    private void saveWorkInformation(WorkInformationDto workInformationDTO, Customer customer) {
        if (workInformationDTO != null) {
            WorkInformation workInformation = modelMapper.map(workInformationDTO, WorkInformation.class);
            workInformation.setCustomer(customer); // устанавливаем связь с Customer
            workInformationRepository.save(workInformation);
        }
    }

    private void saveCustomer(CustomerDTO customerDTO) {
        if (customerDTO != null) {

            Customer customer = modelMapper.map(customerDTO, Customer.class);
            customerRepository.save(customer);
        }
    }


}
