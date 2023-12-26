package mycode.demo2.student;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

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
		// throw new ApiRequestException("opps , error");
        return studentService.getALLStudents();
	}
	@PostMapping
	public void addNewStudent(@RequestBody @Valid Student student) throws Exception{
		// student is coming from the request, and valid dur to added constrains
		studentService.addNewStudent(student);

	}
    
}
