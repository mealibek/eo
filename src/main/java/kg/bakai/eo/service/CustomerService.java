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
import kg.bakai.eo.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final WorkInformationRepository workInformationRepository;
    private final BusinessAddressInfoRepository businessAddressInfoRepository;
    private final DocumentInfoRepository documentInfoRepository;

    private final BusinessInfoRepository businessInfoRepository;
    private final ContactInformationRepository contactInformationRepository;
    private final FinancialInfoRepository financialInfoRepository;

    private final PersonalInfoRepository personalInfoRepository;

    @Transactional
    public void saveCustomerData(AllDto allDto) {
        Customer customer = convertToCustomer(allDto.customer());
        customerRepository.save(customer);

        saveEntityWithCustomer(allDto.workInformation(), this::convertToWorkInformation, workInformationRepository);
        saveEntityWithCustomer(allDto.businessAddressInfo(), this::convertToBusinessAddressInfo, businessAddressInfoRepository);
        saveEntityWithCustomer(allDto.documentInfo(), this::convertToDocumentInfo, documentInfoRepository);
        saveEntityWithCustomer(allDto.businessInfo(), this::convertToBusinessInfo, businessInfoRepository);
        saveEntityWithCustomer(allDto.financialInfo(), this::convertToFinancialInfo, financialInfoRepository);
        saveEntityWithCustomer(allDto.personalInfo(), this::convertToPersonalInfo, personalInfoRepository);
        saveEntityWithCustomer(allDto.contactInformation(), this::convertToContactInformation, contactInformationRepository);
    }

    private <T, D> void saveEntityWithCustomer(D entityDto, Function<D, T> converter, JpaRepository<T, ?> repository) {
        if (entityDto != null) {
            T entity = converter.apply(entityDto);
            repository.save(entity);
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
