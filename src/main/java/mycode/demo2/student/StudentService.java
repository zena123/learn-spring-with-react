package mycode.demo2.student;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service   // business layer
public class StudentService {
    private final StudentDataAccessService studentDataAccessService;

    @Autowired
    public StudentService(StudentDataAccessService studentDataAccessService) {
        this.studentDataAccessService = studentDataAccessService;}

    public List<Student> getALLStudents(){
        return studentDataAccessService.selectAllStudents();
    }
    
}
