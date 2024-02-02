package kg.bakai.eo.repositories;

import kg.bakai.eo.models.Customer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByIdentificationNumber(String identificationNumber);

    Optional<Customer> findBySurnameAndCustomerNameAndOtchestvo(String surname, String customerName, String otchestvo);

    Optional<Customer> findBySurnameAndCustomerName(String surname, String customerName);

    Optional<Customer> findByCustomerNameAndOtchestvo(String customerName, String otchestvo);

    Optional<Customer> findBySurnameAndOtchestvo(String surname, String otchestvo);

    Optional<Customer> findBySurname(String surname);

    Optional<Customer> findByCustomerName(String customerName);

    Optional<Customer> findByOtchestvo(String otchestvo);
}
