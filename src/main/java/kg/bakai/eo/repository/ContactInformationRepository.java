package kg.bakai.eo.repository;

import kg.bakai.eo.models.ContactInformation;
import kg.bakai.eo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInformationRepository  extends JpaRepository<ContactInformation, Long> {
}
