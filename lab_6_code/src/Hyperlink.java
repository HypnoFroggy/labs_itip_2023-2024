import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hyperlink {
    public static void main(String[] args) throws Exception {
        String string = "google.com/a";
        Pattern pattern = Pattern.compile("[A-Za-z]+\\.[A-Za-z]+((/[A-Za-z])+)?");
        Matcher matcher = pattern.matcher(string);
        if (matcher.matches()) {
            System.out.println("https://www."+matcher.group());
        }
        else {
            System.out.println("нет соответствия шаблону");
        }
    }
}
