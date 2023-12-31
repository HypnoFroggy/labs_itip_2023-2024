import java.util.ArrayList;
import java.util.Arrays;
//import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(nonRepeatable("abracadabra"));

        System.out.println(alphabeticRow("abcdefghihgjjjjjjjfghij"));

        System.out.println(collection("abcdefghihgjjjjjjjfghij"));

        System.out.println(convertToNum("one hundred twenty-three"));

        System.out.println(uniqueSubstring("nuli39e3weswqwertyuiopl"));
        int[][] i = {
        {1, 3, 1},
        {1, 5, 1},
        {4, 2, 1}};
        System.out.println(shortestWay(i));

        System.out.println(numericOrder("s3ssds scd1fcv oij4fc ffc2f"));

        System.out.println(switchNums(123456789,9000));

        System.out.println(Arrays.toString(binarySystem(5)));

        System.out.println(Arrays.toString(generateBrackets(5)));
    }
    public static String nonRepeatable(String str) {
        String res = "";
        for (char c : str.toCharArray()) {
            if (!res.contains("" + c)){
                res += c;
            }
        }
        return res;
    }
    public static String alphabeticRow(String str) {
        String max = "";
        ArrayList<String> list = new ArrayList<String>();
        list.add("");
        int pointer = 0;
        boolean check = true;
        char[] c = str.toCharArray();
        int[] arr = new int[c.length];
        for (int index = 0; index < c.length; index++) {
            arr[index] = Character.getNumericValue(c[index]);
        }
        for (int index = 0; index < c.length-1; index++) {
            if (arr[index] == arr[index+1] + 1){
                if (check) {
                    list.add("" + c[index]);
                    check = false;
                    pointer++;
                }
                list.set(pointer,list.get(pointer) + c[index + 1]);
            }
            else {
                check = true;
            }
        }
        check = true;
        for (int index = 0; index < c.length-1; index++) {
            if (arr[index] == arr[index+1] - 1){
                if (check) {
                    list.add("" + c[index]);
                    check = false;
                    pointer++;
                }
                list.set(pointer, list.get(pointer) + c[index + 1]);
            }
            else {
                check = true;
            }
        }
        for (String iter : list) {
            if (iter.length() > max.length()) {
                max = iter;
            }
        }
        return max;
    }
    public static String collection(String str) {
        ArrayList<Character> character = new ArrayList<Character>();
        ArrayList<Integer> count = new ArrayList<Integer>();
        String res = "";
        int len = str.length();
        for (int i = 1; i < len; i++) {
            if (character.contains(str.charAt(i))) {
                count.set(character.indexOf(str.charAt(i)),count.get(character.indexOf(str.charAt(i)))+1);
            }
            else {
                character.add(str.charAt(i));
                count.add(1);
            }
        }
        for (int index = 0; index < count.size(); index++) {
            int buf = count.get(index);
            char c = character.get(index);
            int min = index;
            for (int i = index + 1; i < count.size(); i++) {
                if (count.get(min) > count.get(i)) {
                    min = i;
                }
            }
            count.set(index,count.get(min));
            character.set(index,character.get(min));
            count.set(min,buf);
            character.set(min,c);
        }
        for (int index = 0; index < count.size(); index++) {
            res += character.get(index);
            res += count.get(index);
        }
        return res;
    }
    public static int convertToNum(String string) {
        String str = string.toLowerCase();
        int res = 0;
        String[] s = {"nine hundred","eight hundred","seven hundred","six hundred","five hundred","four hundred","three hundred","two hundred","one hundred",
            "ninety","eighty","seventy","sixty","fifty","fourty","thirty","twenty",
            "nineteen","eighteen","seveteen","sixteen","fifteen","fourteen","thirteen","twelve","eleven","ten",
            "nine","eight","seven","six","five","four","three","two","one"
        };
        int[] i = {900,800,700,600,500,400,300,200,100,
            90,80,70,60,50,40,30,20,
            19,18,17,16,15,14,13,12,11,10,
            9,8,7,6,5,4,3,2,1
        };
        for (int index = 0; index < i.length; index++) {
            if (str.contains(s[index])) {
                res += i[index];
                str = str.replaceAll(s[index], "=");
            }
        }
        return res;
    }
    public static String uniqueSubstring(String str) {
        String max = "";
        ArrayList<String> list = new ArrayList<String>();
        list.add("");
        int pointer = 0;
        char[] c = str.toCharArray();
        for (int index = 0; index < c.length-1; index++) {
            if (!list.get(pointer).contains(c[index]+"")){
                list.set(pointer,list.get(pointer) + c[index]);
            }
            else {
                list.add(c[index]+"");
                pointer++;
            }
        }
        for (String iter : list) {
            if (iter.length() > max.length()) {
                max = iter;
            }
        }
        return max;
    }
    public static int shortestWay(int[][] input) {
        int n = input.length;
        int[][] result = new int[n][n];
        result[0][0] = input[0][0];
        for (int index = 1; index < n; index++) {
            result[0][index] = result[0][index-1] + input[0][index];
            result[index][0] = result[index-1][0] + input[index][1];
        }
        for (int index = 1; index < n; index++) {
            for (int index1 = 1; index1 < n; index1++) {
                if(result[index-1][index1] < result[index][index1-1]) {
                    result[index][index1] = input[index][index1] + result[index-1][index1];
                }
                else {
                    result[index][index1] = input[index][index1] + result[index][index1-1];
                }
            }
        }
        return result[n-1][n-1];
    }
    public static String numericOrder(String str) {
        String s = str;
        ArrayList<String> words = new ArrayList<String>();
        int begining = 0;
        while(s.indexOf( " ") != -1){
            words.add(s.substring(begining, s.indexOf(" ")-1));
            begining = s.indexOf( " ") + 1;
            s = s.replaceFirst(" ", "_");
        }
        words.add(s.substring(begining));
        String[] strings = new String[words.size()];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = words.get(i);
        }
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j <= strings.length; j++) {
                if(strings[i].contains((j) + "")) {
                    String qwe = strings[i].replace(j+"","");
                    strings[i] = strings[j - 1];
                    strings[j - 1] = qwe;
                }
            }
        }
        String res = "";
        for (int i = 0; i < strings.length; i++) {
            res += strings[i] + " ";
        }
        return res;
    }
    public static int switchNums(int a, int b) {
        int[] count = {0,0,0,0,0,0,0,0,0,0};
        String s = a+"";
        for (int i = 0; i < s.length(); i++) {
            count[a % 10]++;
            a /= 10;
        }
        char[] c = (b+"").toCharArray();
        for (int i = 0; i < c.length; i++) {
            for (int j = 9; j > Character.getNumericValue(c[i]); j--) {
                if(count[j] > 0) {
                    c[i] = Integer.toString(j).charAt(0);
                    count[j]--;
                    break;
                }
            }
        }
        b = 0;
        for (int i = c.length-1; i >= 0; i--) {
            b += Character.getNumericValue(c[i]) * (int)Math.pow(10, c.length-i-1);
        }
        return b;
    }
    public static String[] binarySystem(int a) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = (a < 3) ? 0: (int)Math.pow(2, a-1); i < (int)Math.pow(2, a); i++) {
            String s = Integer.toBinaryString(i);
            if (s.length() < a) {
                s = "0" + s;
            }
            if (s.contains("00")) {
                continue;
            }
            list.add(s);
        }
        String[] array = new String[list.size()];
        for (int index = 0; index < array.length; index++) {
            array[index] = list.get(index);
        }
        return array;
    }
    public static String[] generateBrackets(int a) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = (int)Math.pow(2, 2*a-1); i < (int)Math.pow(2, 2*a); i++) {
            String s = Integer.toBinaryString(i);
            String clone = s;
            while (clone.contains("10")) {
                clone = clone.replace("10", "");
            }
            if (clone.length() == 0) {
                s = s.replaceAll("1","(");
                s = s.replaceAll("0",")"); 
                list.add(s);
            }
        }
        String[] array = new String[list.size()];
        for (int index = 0; index < array.length; index++) {
            array[index] = list.get(index);
        }
        return array;
    }
}
