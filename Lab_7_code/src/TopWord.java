import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class TopWord {
    public static void main(String[] args) throws Exception {
        String filePath = "src/txt.txt";
        File file = new File(filePath);
        Scanner s = null;
        try {
            s = new Scanner(file);
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        while (s.hasNext()) {
            String buffer = s.next();
            if (map.containsKey(buffer)) {
                map.replace(buffer, map.get(buffer)+1);
            }
            else {
                map.put(buffer, 1);
            }
        }
        int max = 0;
        if (map.size() > 10) {
            max = 10;
        }
        else {
            max = map.size();
        }
        String[] array = new String[max];
        int[] vals = new int[max];
        for (String string : map.keySet()) {
            int val = map.get(string);
            int buffer = 0;
            String bufferString = "";
            for (int i = 0; i < max; i++) {
                if (val > vals[i]) {
                    for (int j = i; j < max; j++) {
                        buffer = vals[j];
                        bufferString = array[j];
                        vals[j] = val;
                        array[j] = string;
                        val = buffer;
                        string = bufferString;
                    }
                    break;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println((i+1) + " - " + array[i]);
        }
        s.close();
    }
}
