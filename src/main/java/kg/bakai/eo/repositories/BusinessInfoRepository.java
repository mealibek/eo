package kg.bakai.eo.repositories;

import kg.bakai.eo.models.BusinessInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessInfoRepository extends JpaRepository<BusinessInfo, Long> {
}
