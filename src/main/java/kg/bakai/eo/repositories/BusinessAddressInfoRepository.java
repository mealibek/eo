package kg.bakai.eo.repositories;

import kg.bakai.eo.models.BusinessAddressInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessAddressInfoRepository extends JpaRepository<BusinessAddressInfo, Long> {
}