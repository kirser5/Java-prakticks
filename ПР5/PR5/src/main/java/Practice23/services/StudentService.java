package Practice23.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Practice23.output.StudentToUniversityRequest;
import Practice23.models.University;
import Practice23.models.Student;
import Practice23.repositories.UniversityRepository;
import Practice23.repositories.StudentRepository;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {
    private final UniversityRepository universityRepository;
    private final StudentRepository studentRepository;
    // private final EmailService emailService;

    @Transactional
    public void publish(StudentToUniversityRequest request) {
        String universityName = request.getUniversityName();
        University university = universityRepository.findByUniversityName(universityName);
        if (university == null) {
            return;
        }
        Student student = new Student();
        student.setFirstName(request.getStudentFirstName());
        student.setLastName(request.getStudentLastName());
        student.setMiddleName(request.getStudentMiddleName());
        student.setUniversity(university);
        studentRepository.save(student);

        // Testing Criteria API
        log.info("*****Criteria API*****");
        List<Student> studentsByUniversityName = studentRepository.findStudentsByUniversityName("MIREA");
        log.info("-Students by university name:");
        studentsByUniversityName
                .forEach(st ->
                        log.info(st.getLastName() + " " + st.getFirstName() + " " + st.getMiddleName()
                                + " -- " + st.getUniversity().getUniversityName())
                );

        List<Student> studentsByFirstAndLastName = studentRepository
                .findStudentsByFirstNameAndLastName("Arthas", "Menetil");
        log.info("-Students by first and last name:");
        studentsByFirstAndLastName
                .forEach(st ->
                        log.info(st.getLastName() + " " + st.getFirstName() + " " + st.getMiddleName()
                                + " -- " + st.getUniversity().getUniversityName())
                );
        /*
        emailService.send(
                "Student save",
                student.getFirstName() + " from group " + student.getGroup().getGroupName()
                + " has been saved to the database."
        );
        */
    }

    @Transactional
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void delete(long id) {
        studentRepository.deleteById(id);
    }
}