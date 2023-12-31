import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IP {
    public static void main(String[] args) throws Exception {
        String string = "255.255.255.100";
        Pattern pattern = Pattern.compile("([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])){3}");
        Matcher matcher = pattern.matcher(string);
        if (matcher.matches()) {
            System.out.println(matcher.group());
        }
        else {
            System.out.println("нет соответствия шаблону");
        }
    }
}
