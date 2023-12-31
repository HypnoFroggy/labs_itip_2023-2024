import java.util.Arrays;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        // boolean x = duplicateChars("qwertyuiow");
        // String x = getInitials("Ryan Gosling");
        // int[] array = {1,2,3,4,5,6,7,8,9};
        // int x = differenceEvenOdd(array);
        // int[] array = {1,2,3,4,6};
        // boolean x = equalToAvg(array);
        // int[] array = {1,2,3,4,6};
        // int[] x = indexMult(array);
        // String x = reverse("help");
        // int x = Tribonacci(11);
        //String x = botHelper("12helP12");
        // boolean x = isAnagram("hello", "world");
        String x = pseudoHash(90);

        System.out.println(x);
        // System.out.println(Arrays.toString(x));
    }
    public static boolean duplicateChars(String str) {
        HashMap<Character,Integer> count = new HashMap<>();
        count.put(str.charAt(0), 1);
        int len = str.length();
        for (int i = 1; i < len; i++) {
            if (count.containsKey(str.charAt(i))) {
                int j = count.get(str.charAt(i));
                count.put(str.charAt(i), j+1);
            }
            else {
                count.put(str.charAt(i), 1);
            }
        }
        if (count.containsValue(2)) {
            return true;
        }
        else {
            return false;
        }
    }
    public static String getInitials(String str) {
        String res = "";
        res += str.charAt(0);
        boolean check = false;
        for(char c : str.toCharArray()) {
            if (check) {
                res += c;
                check = false;
            }
            if (c == ' ') {
                check = true;
            }
        }
        return res.toUpperCase();
    }
    public static int differenceEvenOdd(int[] arr) {
        int odd = 0;
        int even = 0;
        for (int num : arr) {
            if (num%2 == 0) {
                even += num;
            }
            else {
                odd += num;
            }
        }
        return Math.abs(even - odd);
    }
    public static boolean equalToAvg(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        int avg = sum / arr.length;
        if (sum % arr.length == 0) {
            int f = Arrays.binarySearch(arr, avg);
            return (f >= 0);
        }
        else {
            return false;
        }
    }
    public static int[] indexMult(int[] arr) {
        int[] result = new int[arr.length];
        int pos = 0;
        for (int i : arr) {
            result[pos] = i * pos;
            pos++;
        }
        return result;
    }
    public static String reverse(String str){
        String result = "";
        for (int index = 0; index < str.length(); index++) {
            result += str.charAt(str.length()-index-1);
        }
        return result;
    }
    public static int Tribonacci(int a) {
        if (a == 1) {
            return 0;
        }
        if (a == 2) {
            return 0;
        }
        if (a == 3) {
            return 1;
        }
        int[] arr = new int[a];
        arr[2] = 1;
        for (int i = 3; i < arr.length; i++) {
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }
        return arr[a-1];
    }
    public static String botHelper(String str) {
        if (str.toLowerCase().contains("help")) {
            return "Calling for a staff member";
        }
        else {
            return "Keep waiting";
        }
    }
    public static boolean isAnagram(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        HashMap<Character,Integer> countA = new HashMap<>();
        HashMap<Character,Integer> countB = new HashMap<>();
        countA.put(A.charAt(0), 1);
        countB.put(B.charAt(0), 1);

        for (int i = 1; i < A.length(); i++) {
            if (countA.containsKey(A.charAt(i))) {
                int j = countA.get(A.charAt(i));
                countA.put(A.charAt(i), j+1);
            }
            else {
                countA.put(A.charAt(i), 1);
            }
        }

        for (int i = 1; i < B.length(); i++) {
            if (countB.containsKey(B.charAt(i))) {
                int j = countB.get(B.charAt(i));
                countB.put(B.charAt(i), j+1);
            }
            else {
                countB.put(B.charAt(i), 1);
            }
        }

        if (countA.equals(countB)) {
            return true;
        }
        else {
            return false;
        }
    }
    public static String pseudoHash(int len) {
        String result = "";
        for (int i = 1; i <= len; i++) {
            double r = Math.random();
            if (r < 0.0625) {
                result += "0";
            }
            else if (r < 0.125) {
                result += "1";
            }
            else if (r < 0.1875) {
                result += "2";
            }
            else if (r < 0.25) {
                result += "3";
            }
            else if (r < 0.3125) {
                result += "4";
            }
            else if (r < 0.375) {
                result += "5";
            }
            else if (r < 0.4375) {
                result += "6";
            }
            else if (r < 0.5) {
                result += "7";
            }
            else if (r < 0.5625) {
                result += "8";
            }
            else if (r < 0.625) {
                result += "9";
            }
            else if (r < 0.6875) {
                result += "a";
            }
            else if (r < 0.75) {
                result += "b";
            }
            else if (r < 0.8125) {
                result += "c";
            }
            else if (r < 0.875) {
                result += "d";
            }
            else if (r < 0.9375) {
                result += "e";
            }
            else {
                result += "f";
            }
        }
        return result;
    }
}
