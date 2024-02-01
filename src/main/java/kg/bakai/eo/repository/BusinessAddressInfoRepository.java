package kg.bakai.eo.repository;

import kg.bakai.eo.models.BusinessAddressInfo;
import kg.bakai.eo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessAddressInfoRepository  extends JpaRepository<BusinessAddressInfo, Long> {
}