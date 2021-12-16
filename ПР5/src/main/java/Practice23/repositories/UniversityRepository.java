package Practice23.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Practice23.models.University;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {
    University findByUniversityName(String universityName);
}