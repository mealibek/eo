package kg.bakai.eo.repositories;

import kg.bakai.eo.models.DocumentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentInfoRepository extends JpaRepository<DocumentInfo, Long> {
}
