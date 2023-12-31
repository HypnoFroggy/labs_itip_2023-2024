import java.util.ArrayList;
@DataProcessor
public class AsIntended extends App{
    @DataProcessor
    public String process(ArrayList<String> string) {
        String res = "";
        for (String string2 : string) {
            res +=  string2;
        }
        return res;
    }
}
