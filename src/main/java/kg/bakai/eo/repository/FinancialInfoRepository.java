package kg.bakai.eo.repository;

import kg.bakai.eo.models.FinancialInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialInfoRepository extends JpaRepository<FinancialInfo, Long> {
}
