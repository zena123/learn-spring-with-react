package mycode.demo2.student;

import java.util.List;
import java.util.UUID;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository   //data access layer
public class StudentDataAccessService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    StudentDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    List<Student> selectAllStudents(){
        String sql = "" + "SELECT student_id, first_name, last_name, email, gender from student"; 

        return jdbcTemplate.query(sql, ( resultSet, i) -> {
            String idStr = resultSet.getString("student_id");
            UUID studentId = UUID.fromString(idStr);
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String email = resultSet.getString("email");
            String genderStr = resultSet.getString("gender").toUpperCase();
            return new Student(studentId,
             firstName,
              lastName, 
              email, 
              Student.Gender.valueOf(genderStr)
              );
        });
    }

    int insertStudent(UUID newId, Student student) {
            String sql = "" + "INSERT INTO student VALUES (?, ?, ?, ?, ?)";
            // jdbc template will return 0 or 1

            return jdbcTemplate.update(sql,
            newId, 
            student.getFirstName(), student.getLastName(), student.getEmail(),
            student.getGender().name().toUpperCase());
            
        }

    boolean isEmailTaken(String email) {
        String sql = "SELECT EXISTS ( SELECT 1 FROM STUDENT WHERE email = ?)";
        return jdbcTemplate.queryForObject(sql, 
            new Object[]{email},
            (resultSet,i) -> resultSet.getBoolean(1)
            );
    }    
}
