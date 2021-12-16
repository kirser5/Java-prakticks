package Practice23.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Practice23.output.StudentToUniversityRequest;
import Practice23.models.University;
import Practice23.repositories.UniversityRepository;
import Practice23.repositories.StudentRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Slf4j
@Service
@RequiredArgsConstructor
public class UniversityService {
    private final UniversityRepository universityRepository;
    private final StudentRepository studentRepository;
    // private final EmailService emailService;

    @Transactional
    public void publish(StudentToUniversityRequest request) {
        String universityName = request.getUniversityName();
        University university = universityRepository.findByUniversityName(universityName);
        if (university != null) {
            return;
        }
        university = new University();
        university.setUniversityName(request.getUniversityName());
        universityRepository.save(university);
        /*
        emailService.send(
                "Group save",
                group.getGroupName() + " has been saved to the database."
        );
        */
    }

    @Transactional
    public <T> T takeAllUniversities(Function<List<University>, T> tooutput) {
        List<University> universities = universityRepository.findAll();
        return tooutput.apply(universities);
    }

    @Transactional
    public List<University> getAllUniversities() {
        return universityRepository.findAll();
    }

    @Transactional
    public <T> T takeUniversityById(long id, Function<University, T> tooutput) {
        Optional<University> university = universityRepository.findById(id);
        if (university.isEmpty()) {
            return null;
        }
        return tooutput.apply(university.get());
    }

    @Transactional
    public void delete(long id) {
        Optional<University> university = universityRepository.findById(id);
        if (university.isEmpty()) {
            return;
        }
        studentRepository.deleteAllByUniversity(university.get());
        universityRepository.deleteById(id);
    }
}