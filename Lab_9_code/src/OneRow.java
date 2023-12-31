import java.util.ArrayList;
@DataProcessor
public class OneRow extends App{
    @DataProcessor
    public String process(ArrayList<String> string) {
        String res = "";
        for (String string2 : string) {
            res += "\n" + string2;
        }
        return res;
    }
}
