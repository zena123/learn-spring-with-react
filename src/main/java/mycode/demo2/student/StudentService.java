package mycode.demo2.student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mycode.demo2.EmailValidator;




@Service   // business layer
public class StudentService {
    private final StudentDataAccessService studentDataAccessService;
    private final EmailValidator emailValidator;


    @Autowired
    public StudentService(StudentDataAccessService studentDataAccessService, EmailValidator emailValidator) {
        this.studentDataAccessService = studentDataAccessService;
    this.emailValidator = emailValidator;}

    public List<Student> getALLStudents(){
        return studentDataAccessService.selectAllStudents();
    }

    public void addNewStudent(Student student) throws Exception {
        addNewStudent(null, student);
    }
    public void addNewStudent( UUID studentId,Student student) throws Exception{
        UUID newId = Optional.ofNullable(studentId).orElse(UUID.randomUUID());

        if (! emailValidator.test(student.getEmail())){
            throw new Exception("email not valid");
        }
        studentDataAccessService.insertStudent(newId, student);
        
    }
    
}
