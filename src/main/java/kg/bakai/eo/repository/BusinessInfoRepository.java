package kg.bakai.eo.repository;

import jakarta.persistence.Entity;
import kg.bakai.eo.models.BusinessInfo;
import kg.bakai.eo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessInfoRepository  extends JpaRepository<BusinessInfo, Long> {
}
