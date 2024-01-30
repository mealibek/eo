package kg.bakai.eo.repository;

import kg.bakai.eo.models.WorkInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkInformationRepository extends JpaRepository<WorkInformation, Long> {
}
