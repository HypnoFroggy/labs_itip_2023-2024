import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumericFinder {
    public static void main(String[] args) throws Exception {
        String string = "q123wdhdue1.2345sdj";
        Pattern pattern = Pattern.compile("\\d+\\.\\d+");
        Pattern pattern1 = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            System.out.println(matcher.group());
            string = string.replace(matcher.group(),"");
        }
        matcher = pattern1.matcher(string);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
