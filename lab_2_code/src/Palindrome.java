public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            if (isPalindrome(s)) {
                System.out.println(s);
            }
            
        }
    }
    public static String reverseString(String s) {
        String res = "";
        int count = s.length() - 1;
        while (count >= 0) {
            res += s.charAt(count);
            count--;
        }
        return res;
    }
    public static boolean isPalindrome(String s) {
        String s1 = reverseString(s);
        return s.equals(s1);
    }
}

