package mycode.demo2;

import java.util.function.Predicate;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

//this class will only return true or false
@Component  // to be injected in our class
public class EmailValidator implements Predicate<String> {
    private static final Predicate IS_EMAIL_VALID= 
    Pattern.compile
    ("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
    Pattern.CASE_INSENSITIVE).asPredicate();

    @Override
    public boolean test(String email) {
        return IS_EMAIL_VALID.test(email);
    }
}
