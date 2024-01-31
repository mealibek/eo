package kg.bakai.eo.service;

import jakarta.transaction.Transactional;
import kg.bakai.eo.dto.AddressInfoDto;
import kg.bakai.eo.dto.AllDto;
import kg.bakai.eo.dto.BusinessAddressInfoDto;
import kg.bakai.eo.dto.BusinessInfoDto;
import kg.bakai.eo.dto.ContactInformationDto;
import kg.bakai.eo.dto.CustomerDto;
import kg.bakai.eo.dto.DocumentInfoDto;
import kg.bakai.eo.dto.FinancialInfoDto;
import kg.bakai.eo.dto.PersonalInfoDto;
import kg.bakai.eo.dto.WorkInformationDto;
import kg.bakai.eo.models.AddressInfo;
import kg.bakai.eo.models.BusinessAddressInfo;
import kg.bakai.eo.models.BusinessInfo;
import kg.bakai.eo.models.ContactInformation;
import kg.bakai.eo.models.Customer;
import kg.bakai.eo.models.DocumentInfo;
import kg.bakai.eo.models.FinancialInfo;
import kg.bakai.eo.models.PersonalInfo;
import kg.bakai.eo.models.WorkInformation;
import kg.bakai.eo.repository.CustomerRepository;
import kg.bakai.eo.repository.WorkInformationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final WorkInformationRepository workInformationRepository;

    @Transactional
    public void saveCustomerData(AllDto allDto) {
        Customer customer = convertToCustomer(allDto.customer());
        customerRepository.save(customer);
        WorkInformationDto workInformationDTO = allDto.workInformation();
        if (workInformationDTO != null) {
            WorkInformation workInformation = convertToWorkInformation(workInformationDTO);
            workInformation.setCustomer(customer); // устанавливаем связь с Customer
            workInformationRepository.save(workInformation);
        }
    }

    private Customer convertToCustomer(CustomerDto customerDto) {
        Customer customer = new Customer(customerDto);
        customer.setResidenceAddress(convertToAddressInfo(customerDto.residenceAddress()));
        customer.setRegistrationAddress(convertToAddressInfo(customerDto.registrationAddress()));
        return customer;
    }

    private AddressInfo convertToAddressInfo(AddressInfoDto addressInfoDto) {
        return new AddressInfo(addressInfoDto);
    }

    private WorkInformation convertToWorkInformation(WorkInformationDto workInformationDto) {
        return new WorkInformation(workInformationDto);
    }

    private BusinessAddressInfo convertToBusinessAddressInfo(BusinessAddressInfoDto businessAddressInfoDto) {
        return new BusinessAddressInfo(businessAddressInfoDto);
    }

    private BusinessInfo convertToBusinessInfo(BusinessInfoDto businessInfoDto) {
        return new BusinessInfo(businessInfoDto);
    }

    private ContactInformation convertToContactInformation(ContactInformationDto contactInformationDto) {
        return new ContactInformation(contactInformationDto);
    }

    private DocumentInfo convertToDocumentInfo(DocumentInfoDto documentInfoDto) {
        return new DocumentInfo(documentInfoDto);
    }

    private FinancialInfo convertToFinancialInfo(FinancialInfoDto financialInfoDto) {
        return new FinancialInfo(financialInfoDto);
    }

    private PersonalInfo convertToPersonalInfo(PersonalInfoDto personalInfoDto) {
        return new PersonalInfo(personalInfoDto);
    }
}
