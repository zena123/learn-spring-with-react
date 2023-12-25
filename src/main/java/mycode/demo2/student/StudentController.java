package mycode.demo2.student;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("students")
public class StudentController {
	private final StudentService studentService;

	@Autowired  //dependancy injection
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
    @GetMapping
	public List<Student> getAllStudents() {
		// return studentService.getStudents();
        return studentService.getALLStudents();
	}
	@PostMapping
	public void addNewStudent(@RequestBody Student student){  // student is coming from the request
		studentService.addNewStudent(student);

	}
    
}
