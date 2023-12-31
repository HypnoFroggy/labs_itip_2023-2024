import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("replaceVovels(\"null\")");
        System.out.println(replaceVovels("null"));

        System.out.println("stringTransform(\"null\")");
        System.out.println(stringTransform("null"));

        System.out.println("doesBlockFit(1, 2, 2, 1, 1)");
        System.out.println(doesBlockFit(1, 2, 2, 1, 1));

        System.out.println("numCheck(243)");
        System.out.println(numCheck(243));

        System.out.println("countRoots(1, 2, 3)");
        System.out.println(countRoots(1, 2, 3));

        System.out.println("validSplit(\"apple eagle egg goat\")");
        System.out.println(validSplit("apple eagle egg goat"));

        System.out.println("salesData(["+
            "[\"Apple\", \"Shop1\", \"Shop2\", \"Shop3\", \"Shop4\"], \n" +
            "[\"Banana\", \"Shop2\", \"Shop3\", \"Shop4\"], \n" + 
            "[\"Orange\", \"Shop1\", \"Shop3\", \"Shop4\"], \n" + 
            "[\"Pear\", \"Shop2\", \"Shop4\"] \n" + 
            "])");
        String[][] x = {
            {"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
            {"Banana", "Shop2", "Shop3", "Shop4"},
            {"Orange", "Shop1", "Shop3", "Shop4"},
            {"Pear", "Shop2", "Shop4"}
        };
        System.out.println(Arrays.toString(salesData(x)));

        System.out.println("waveForm([3, 1, 4, 2, 7, 5])");
        int[] a = {3, 1, 4, 2, 7, 5};
        System.out.println(waveForm(a));

        System.out.println("commonVovel(\"Hello world\") ");
        System.out.println(commonVovel("Hello world"));

        System.out.println("dataScience([\n" + //
                "[1, 2, 3, 4, 5],\n" + //
                "[6, 7, 8, 9, 10],\n" + //
                "[5, 5, 5, 5, 5],\n" + //
                "[7, 4, 3, 14, 2],\n" + //
                "[1, 0, 11, 10, 1]\n" + //
                "])");
        int[][] b = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 29, 10},
            {5, 5, 5, 5, 35},
            {7, 4, 3, 14, 2},
            {1, 0, 11, 10, 1}
        };
        b = dataScience(b);
        for (int i = 0; i < b.length; i++) {
            System.out.println(Arrays.toString(b[i]));
        }
    }
    public static String replaceVovels(String str) {
        str = str.replace("a","*");
        str = str.replace("e","*");
        str = str.replace("i","*");
        str = str.replace("y","*");
        str = str.replace("o","*");
        str = str.replace("u","*");
        return str;
    }
    public static String stringTransform(String str) {
        char[] ChArr = str.toCharArray();
        String res = "";
        int index = 1;

        if (ChArr.length == 1) {
            return str;
        }

        if (ChArr[0] == ChArr[1]) {
            res += "Double" + ChArr[0];
            index = 2;
        }
        else {
            res += ChArr[0];
        }

        while (index < ChArr.length) {
            if (ChArr[index-1] == ChArr[index]) {
                res += "Double" + ChArr[index];
            }
            else {
                res += ChArr[index];
            }
            index++;
        }
        return res;
    }
    public static boolean doesBlockFit(int a, int b, int c, int w, int h) {
        int[][] sides = {{a,b},{b,a},{c,b},{b,c},{a,c},{c,a}};
        for (int index = 0; index < sides.length; index++) {
            if ((sides[index][0] <= w) && (sides[index][1] <=h)) {
                return true;
            }
        }
        return false;
    }
    public static boolean numCheck(int num) {
        int i = 10;
        int j = 1;
        int sum = 0;
        while (num > num % j) {
            sum += Math.pow((num%i/j),2);
            i *= 10;
            j *= 10;
        }
        return sum % 2 == num % 2;
    }
    public static int countRoots(int a, int b, int c) {
        int d = b*b + 4*c*a;
        if (d == 0) {
            if ((-b /(double)(2*a)) % 1 == 0) {
                return 1;
            }
        }
        if (d > 0) {
            int count = 0;
            if ((-b + Math.sqrt(d))/(2*a) % 1 == 0) {
                count++;
            }
            if ((-b - Math.sqrt(d))/(2*a) % 1 == 0) {
                count++;
            }
            return count;
        }
        return 0;
    }
    public static String[] salesData(String[][] myStrings) {
        int count = 0;
        ArrayList<String> output = new ArrayList<String>();
        for (String[] arr : myStrings) {
            if (arr.length > count) {
                count = arr.length;
            }
        }
        for (String[] arr : myStrings) {
            if (arr.length == count) {
                output.add(arr[0]);
            }
        }
        String[] out = new String[output.size()];
        return output.toArray(out);
    }
    public static boolean validSplit(String str) {
        char[] c = str.trim().toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                if (c[i-1] != c[i+1]){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean waveForm(int[] a) {
        boolean step = false;
        if (a[0] == a[1]) {
            return false;
        }
        if (a[0] > a[1]) {
            step = false;
        }
        if (a[0] < a[1]) {
            step = true;
        }
        
        for (int i = 2; i < a.length; i++) {
            if (a[i-1] == a[i]) {
                return false;
            }
            if (a[i-1] > a[i]) {
                if (!step) {
                    return false;
                }
                step = false;
            }
            if (a[i-1] < a[i]) {
                if (step) {
                    return false;
                }
                step = true;
            }
        }
        return true;
    }
    public static char commonVovel(String str) {
        HashMap<Character,Integer> count = new HashMap<>();
        count.put('a', 0);
        count.put('o', 0);
        count.put('u', 0);
        count.put('i', 0);
        count.put('e', 0);
        count.put('y', 0);
        int len = str.length();
        for (int i = 1; i < len; i++) {
            if (count.containsKey(str.charAt(i))) {
                int j = count.get(str.charAt(i));
                count.put(str.charAt(i), j+1);
            }
        }
        char[] carr = {'a','o','e','u','i','y'};
        char maxChar = ' ';
        int max = 0;
        for (char c : carr) {
            if (count.get(c) > max) {
                maxChar = c;
                max = count.get(c);
            }
        }
        return maxChar;
    }
    public static int[][] dataScience(int[][] arr) {
        int[] mathExp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                mathExp[j] += arr[i][j];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = (mathExp[i] - arr[i][i])/(arr.length-1);
        }
        return arr;
    }
}
