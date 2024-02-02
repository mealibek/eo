package kg.bakai.eo.services;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

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
import kg.bakai.eo.models.BusinessAddressInfo;
import kg.bakai.eo.models.BusinessInfo;
import kg.bakai.eo.models.ContactInformation;
import kg.bakai.eo.models.Customer;
import kg.bakai.eo.models.DocumentInfo;
import kg.bakai.eo.models.FinancialInfo;
import kg.bakai.eo.models.PersonalInfo;
import kg.bakai.eo.models.WorkInformation;
import kg.bakai.eo.repositories.BusinessAddressInfoRepository;
import kg.bakai.eo.repositories.BusinessInfoRepository;
import kg.bakai.eo.repositories.ContactInformationRepository;
import kg.bakai.eo.repositories.CustomerRepository;
import kg.bakai.eo.repositories.DocumentInfoRepository;
import kg.bakai.eo.repositories.FinancialInfoRepository;
import kg.bakai.eo.repositories.PersonalInfoRepository;
import kg.bakai.eo.repositories.WorkInformationRepository;

@SpringBootTest
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private WorkInformationRepository workInformationRepository;

    @Mock
    private BusinessAddressInfoRepository businessAddressInfoRepository;

    @Mock
    private DocumentInfoRepository documentInfoRepository;

    @Mock
    private BusinessInfoRepository businessInfoRepository;

    @Mock
    private ContactInformationRepository contactInformationRepository;

    @Mock
    private FinancialInfoRepository financialInfoRepository;

    @Mock
    private PersonalInfoRepository personalInfoRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    public void saveCustomerData_Success() {
        AllDto mockAllDto = createMockAllDto();

        customerService.saveCustomerData(mockAllDto);

        verifyRepositories();
    }

    @Test
    public void saveCustomerData_WithNullAllDto() {
        assertThrows(IllegalArgumentException.class, () -> {
            customerService.saveCustomerData(null);
        });
    }

    private void verifyRepositories() {
        verify(customerRepository, times(1)).save(any(Customer.class));
        verify(workInformationRepository, times(1)).save(any(WorkInformation.class));
        verify(businessAddressInfoRepository, times(1)).save(any(BusinessAddressInfo.class));
        verify(documentInfoRepository, times(1)).save(any(DocumentInfo.class));
        verify(businessInfoRepository, times(1)).save(any(BusinessInfo.class));
        verify(contactInformationRepository, times(1)).save(any(ContactInformation.class));
        verify(financialInfoRepository, times(1)).save(any(FinancialInfo.class));
        verify(personalInfoRepository, times(1)).save(any(PersonalInfo.class));
    }

    private void verifyNoRepositoryInteractions() {
        verify(customerRepository, times(0)).save(any(Customer.class));
        verify(workInformationRepository, times(0)).save(any(WorkInformation.class));
        verify(businessAddressInfoRepository, times(0)).save(any(BusinessAddressInfo.class));
        verify(documentInfoRepository, times(0)).save(any(DocumentInfo.class));
        verify(businessInfoRepository, times(0)).save(any(BusinessInfo.class));
        verify(contactInformationRepository, times(0)).save(any(ContactInformation.class));
        verify(financialInfoRepository, times(0)).save(any(FinancialInfo.class));
        verify(personalInfoRepository, times(0)).save(any(PersonalInfo.class));
    }

    private AllDto createMockAllDto() {
        return new AllDto(
                createCustomerDto(),
                createBusinessAddressInfoDto(),
                createBusinessInfoDto(),
                createContactInformationDto(),
                createDocumentInfoDto(),
                createFinancialInfoDto(),
                createPersonalInfoDto(),
                createWorkInformationDto());
    }

    private CustomerDto createCustomerDto() {
        AddressInfoDto mockRegistrationAddressInfoDto = new AddressInfoDto(1L, "720000", 1, 1, "Karakol", "Kadyrov 108",
                "108", "2");

        AddressInfoDto mockResidenceAddressInfoDto = new AddressInfoDto(1L, "720000", 1, 1, "Karakol", "Kadyrov 108",
                "108", "2");

        CustomerDto mockCustomerDto = new CustomerDto(1L, 1, "Altynbek uulu", "Alibek",
                "", (byte) 1, "12345678901234",
                1, true, LocalDate.of(2002, 3, 2), 1, "Karakol", "Kyrgyzstan", mockRegistrationAddressInfoDto,
                mockResidenceAddressInfoDto);

        return mockCustomerDto;
    }

    private BusinessAddressInfoDto createBusinessAddressInfoDto() {
        BusinessAddressInfoDto mockBusinessAddressInfoDto = new BusinessAddressInfoDto(1L, 1L, 1, 1, "Bishkek",
                "Manas 12", "Avangard 12.", "Business Flat 1", "720100", LocalDate.of(2022, 1, 1), 3);

        return mockBusinessAddressInfoDto;
    }

    private BusinessInfoDto createBusinessInfoDto() {
        BusinessInfoDto mockBusinessInfoDto = new BusinessInfoDto(1L, 1L, 1, (byte) 1, (byte) 1, 121212, 13, 15, 2, 3,
                1, 2, LocalDate.of(2020, 1, 1));
        return mockBusinessInfoDto;
    }

    private WorkInformationDto createWorkInformationDto() {
        WorkInformationDto mockWorkInformationDto = new WorkInformationDto(1L, 1L,
                "Work Name 1", "Work Position 1", "+996700100300", 1, 1, 1, 1, LocalDate.of(2022, 1, 1),
                LocalDate.of(2023, 10, 10), false, null, null, null,
                null, null, null, null, null);

        return mockWorkInformationDto;
    }

    private PersonalInfoDto createPersonalInfoDto() {
        PersonalInfoDto mockPersonalInfoDto = new PersonalInfoDto(1L, 1L, 1, 1, (byte) 1, "Business Address Remark",
                (byte) 1, 1, LocalDate.of(2020, 10, 12), 2, (byte) 0, 0, 0);

        return mockPersonalInfoDto;
    }

    private FinancialInfoDto createFinancialInfoDto() {
        FinancialInfoDto mockFinancialInfoDto = new FinancialInfoDto(1L, 1L, "Comment 1", 1, (byte) 0, 1, (byte) 1,
                (byte) 1, "Comment 1", (byte) 1, (byte) 1, 1, (byte) 1, 1, "Code Name 1", (byte) 1, (byte) 1, (byte) 1,
                (byte) 1, (byte) 1);

        return mockFinancialInfoDto;
    }

    private DocumentInfoDto createDocumentInfoDto() {
        DocumentInfoDto mockDocumentInfoDto = new DocumentInfoDto(1L, 1L, 1, "Document Series 1", "121234",
                LocalDate.of(2000, 10, 10), "Issue AUTHOR 1", LocalDate.of(2030, 1, 1));

        return mockDocumentInfoDto;
    }

    private ContactInformationDto createContactInformationDto() {
        ContactInformationDto mockContactInformationDto = new ContactInformationDto(1L, 1L, "+996700100100",
                "+996700100101", "Contact Address 1", "Contact Person 1", "+996705131313", "contactperson@gmail.com");
        return mockContactInformationDto;
    }
}
