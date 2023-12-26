package mycode.demo2;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class EmailValidatorTests {
    private final EmailValidator underTest = new EmailValidator();

    @Test
    public void testValidEmail(){
        assertThat(underTest.test("test@gmail.com")).isTrue();
    }

      @Test
    public void tesNottValidEmail(){
        assertThat(underTest.test("test.com")).isFalse();
    }
    
}
