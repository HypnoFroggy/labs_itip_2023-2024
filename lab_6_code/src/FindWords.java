import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindWords {
    public static void main(String[] args) throws Exception {
        String string = "bol bool ball ab BB ba AB";
        Pattern pattern = Pattern.compile("\\bb[A-Za-z]+");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            System.out.println(matcher.group());
            string = string.replace(matcher.group(),"");
        }
        pattern = Pattern.compile("\\bB[A-Za-z]+");
        matcher = pattern.matcher(string);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
