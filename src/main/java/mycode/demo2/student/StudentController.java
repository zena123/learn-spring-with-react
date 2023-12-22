package mycode.demo2.student;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("students")
public class StudentController {
    @GetMapping
	public List<Student> getAllStudents() {
		// return studentService.getStudents();
        return List.of(
            		new Student(
            			UUID.randomUUID(),
            			"Tom",
            			"last",
            			"test@gmail.com",
            			Student.Gender.MALE
            		),
					new Student(UUID.randomUUID(),
            			"Tomia",
            			"last",
            			"test1@gmail.com",
            			Student.Gender.FEMALE)
            	);
	}
    
}
