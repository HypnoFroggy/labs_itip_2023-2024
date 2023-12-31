import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheck {
    public static void main(String[] args) throws Exception {
        String string = "100000A00a0";
        Pattern p1 = Pattern.compile("(\\d|[A-Z]|[a-z]){8,16}");
        Pattern p2 = Pattern.compile("[A-Z]");
        Matcher m1 = p1.matcher(string);
        Matcher m2 = p2.matcher(string);
        if (m1.matches()&&m2.find()) {
            System.out.println("это пароль");
        }
        else {
            System.out.println("это не пароль");
        }
    }
}
