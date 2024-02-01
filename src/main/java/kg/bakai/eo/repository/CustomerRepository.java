package kg.bakai.eo.repository;

import kg.bakai.eo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByIdentificationNumber(String identificationNumber);

    Customer findBySurnameAndCustomerNameAndOtchestvo(String surname, String customerName, String otchestvo);

    Customer findBySurnameAndCustomerName(String surname, String customerName);

    Customer findByCustomerNameAndOtchestvo(String customerName, String otchestvo);

    Customer findBySurnameAndOtchestvo(String surname, String otchestvo);

    Customer findBySurname(String surname);

    Customer findByCustomerName(String customerName);

    Customer findByOtchestvo(String otchestvo);
}
