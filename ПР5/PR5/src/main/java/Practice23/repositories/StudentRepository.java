package Practice23.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Practice23.models.University;
import Practice23.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, StudentFilter {
    void deleteAllByUniversity(University university);
}