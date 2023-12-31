import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        System.out.println(Arrays.toString(collect("intercontinentalisationalism", 6)));
        System.out.println(Arrays.toString(isExact(6)));
        System.out.println(fractions("0.(6)"));
        int[] arr = {1, 2, 3, 9, 4, 15, 3, 5};
        System.out.println(Arrays.toString(twoProduct(arr, 45)));
        System.out.println(pilish_string("33314444"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(generateNonconsecutive("6 – 18 / (-1 + 4)"));
        System.out.println(findLCS("aggtab", "gxtxamb"));
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
    }
    public static String hiddenAnagram(String s1, String s2) {
        // создаем данные и приводим их в операбельный вид
        String res = "notfound";
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        String myString = "";
        String myFindString = "";
        Pattern pattern = Pattern.compile("[a-z]+");
        Matcher matcher = pattern.matcher(s1);
        while (matcher.find()) {
            myString += matcher.group();
        }
        matcher = pattern.matcher(s2);
        while (matcher.find()) {
            myFindString += matcher.group();
        }
        char[] myChars = myString.toCharArray();
        char[] findThisChars = myFindString.toCharArray();
        HashMap<Character,Integer> findThisMap = new HashMap<Character,Integer>();
        HashMap<Character,Integer> dynamicMap = new HashMap<Character,Integer>();
        // заполняем начальные коллекции
        for (int i = 0; i < findThisChars.length; i++) {
            if (findThisMap.containsKey(findThisChars[i])) {
                findThisMap.replace(findThisChars[i], findThisMap.get(findThisChars[i])+1);
            }
            else {
                findThisMap.put(findThisChars[i], 1);
            }
            if (dynamicMap.containsKey(myChars[i])) {
                dynamicMap.replace(myChars[i], dynamicMap.get(myChars[i])+1);
            }
            else {
                dynamicMap.put(myChars[i], 1);
            }
        }
        // сравниваем коллекции при нулевых условиях
        int length = findThisChars.length;
        if (dynamicMap.equals(findThisMap)) {
            res = myString.substring(0,length);
        }
        else {
            for (int i = 0; i <= myChars.length - length -1; i++) {
                // обновляем коллекцию среза строки
                if (dynamicMap.get(myChars[i]) == 1) {
                    dynamicMap.remove(myChars[i]);
                }
                else {
                    dynamicMap.replace(myChars[i], dynamicMap.get(myChars[i])-1);
                }
                if (dynamicMap.containsKey(myChars[i+length])) {
                    dynamicMap.replace(myChars[i+length], dynamicMap.get(myChars[i+length])+1);
                }
                else {
                    dynamicMap.put(myChars[i+length], 1);
                }
                // проверяем на сходство
                if (dynamicMap.equals(findThisMap)) {
                    res = myString.substring(i+1,i+length+1);
                    break;
                }
            }
        }
        return res;
    }
    public static String[] collect(String string, int length) {
        int n = string.length()/length;
        String[] res = new String[n];
        String[] sub = new String[n];
        int[] ord = new int[n];
        for (int i = 0; i < sub.length; i++) {
            sub[i] = string.substring(length*i, length*i+length);
            for (int index = 0; index < sub[i].toCharArray().length; index++) {
                ord[i] = ord[i]*100+(int)sub[i].charAt(index);
            }
        }
        int min = 0;
        int minj = 0;
        for (int i = 0; i < ord.length; i++) {
            min = ord[i];
            minj = i;
            for (int j = i; j < ord.length; j++) {
                if (min > ord[j]) {
                    minj = j;
                    min = ord[j];
                }
            }
            min = ord[i];
            ord[i] = ord[minj];
            ord[minj] = min;
            res[i] = sub[minj];
            sub[minj] = sub[i];
        }
        return res;
    }
    public static int[] isExact(int n) {
        int s = factorial(n, 1, 1);
        if (s == -1) {
            return new int[0];
        }
        int[] a = {n,s};
        return a;
    }
    public static int factorial(int n, int count, int countfact) {
        if (n > countfact) {
            return factorial(n, count+1, countfact*(count+1));
        }
        if (n == countfact) {
            return count;
        }
        return -1;
    }
    public static String fractions(String numString) {
        String buffer = "";
        String buffer1 = "";
        String period = numString.substring(numString.indexOf('(')+1,numString.indexOf(')'));
        int length = 0;
        Pattern pattern = Pattern.compile("[0-9]+.");
        Matcher matcher = pattern.matcher(numString);
        if (matcher.find()) {
            buffer1 = matcher.group();
            buffer = numString.replace(buffer1, "").replace("(", "").replace(")", "");
            length = buffer.length();
        }
        buffer1 = buffer1.replace(".", buffer);
        int a = (int)Math.pow(10, length) - (int)Math.pow(10, period.length()-1);
        int c = Integer.parseInt(buffer1.substring(0,buffer1.length() - length));
        int b = Integer.parseInt(buffer) + a*c;
        int b1 = b;
        int a1 = a;
        while (a1 != 0 && b1 != 0) {
            if (a1 > b) {
                a1 = a1 % b1;
            }
            else {
                b1 = b1 % a1;
            }
        }
        String res = b / (a1 + b1) + "/" + a / (a1 + b1);
        return res; 
    }
    public static int[] twoProduct(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]*arr[j] == n) {
                    int[] a = {arr[i],arr[j]};
                    return a;
                }
            }
        }
        return new int[0];
    }
    public static String pilish_string(String string) {
        StringBuilder s = new StringBuilder(string);
        int[] array = {3,1,4,1,5,9,2,6,5,3,5,8,9,7,9};
        int length = 0;
        int maxi = 0;
        while (length < s.length()) {
            length += array[maxi];
            maxi++;
        }
        char c = s.charAt(s.length()-1);
        while (length > s.length()) {
            s.append(c);
        }
        int sum = 0;
        for (int i = 0; i < maxi; i++) {
            sum += array[i];
            s.insert(sum, ' ');
            sum++;
        }
        return s.toString();
    }
    public static String isValid(String string) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.replace(chars[i], map.get(chars[i])+1);
            }
            else {
                map.put(chars[i], 1);
            }
        }
        HashMap<Integer,ArrayList<Character>> remap = new HashMap<Integer,ArrayList<Character>>();
        for (char c : map.keySet()) {
            int c1 = map.get(c);
            if (remap.containsKey(c1)) {
                remap.get(c1).add(c);
            }
            else {
                remap.put(c1, new ArrayList<Character>());
                remap.get(c1).add(c);
            }
        }
        if (remap.size() == 1) {
            return "YES";
        }
        if (remap.size() == 2) {
            Integer[] a = new Integer[2];
            a = remap.keySet().toArray(a);
            if (a[0] == a[1]-1 && remap.get(a[1]).size() == 1) {
                return "YES";
            }
            if (a[1] == a[0]-1 && remap.get(a[0]).size() == 1) {
                return "YES";
            }
            return "NO";
        }
        return "NO";
    }
    public static String generateNonconsecutive(String expression) {
        String err = "";
        // приводим строку в операбельный вид
        String exp = expression.replaceAll(" ", "");
        Pattern p = Pattern.compile("^\\([0-9*\\-+\\/]*\\)");
        Matcher m = p.matcher(exp);
        if (m.find()) {
            return "неверная строка";
        }
        // ищем выражения в скобках и кидаем результат их преобразования (рекурсией)
        Pattern pattern = Pattern.compile("\\([0-9*\\-+\\/]*\\)");
        Matcher matcher = pattern.matcher(exp);
        while (matcher.find()) {
            exp = exp.replace(matcher.group(), generateNonconsecutive(matcher.group().replace("(", "").replace(")","")));
            // System.out.println("без скобок " + exp);
        }
        if (exp.contains("произошло деление на ноль")) {
            return "произошло деление на ноль";
        }
        if (!"".equals(err)) {
            return err;
        }
        ArrayList<Integer> bufferNum = new ArrayList<Integer>();
        ArrayList<Character> bufferOps = new ArrayList<Character>();
        pattern = Pattern.compile("\\d+");
        matcher = pattern.matcher(exp);
        Pattern pattern1 = Pattern.compile("[+*/\\-]+");
        Matcher matcher1 = pattern1.matcher(exp);
        int j = 1;
        String op = "";
        char r = ' ';
        boolean check = matcher.find();
        boolean check1 = matcher1.find();
        while (check||check1) {
            if (check) {
                bufferNum.add(Integer.parseInt(matcher.group())*j);
                j = 1;
            }
            if (check1) {
                op = matcher1.group();
                if ("+-".equals(op)||"-+".equals(op)) {
                    r = '-';
                    j = 1;
                }
                if ("--".equals(op)) {
                    r = '+';
                    j = 1;
                }
                if ("*-".equals(op)||"-*".equals(op)) {
                    r = '*';
                    j = -1;
                }
                if ("/-".equals(op)||"-/".equals(op)) {
                    r = '/';
                    j = -1;
                }

                if ("+".equals(op)) {
                    r = '+';
                    j = 1;
                }
                if ("-".equals(op)) {
                    r = '-';
                    j = 1;
                }
                if ("*".equals(op)) {
                    r = '*';
                    j = 1;
                }
                if ("/".equals(op)) {
                    r = '/';
                    j = 1;
                }
                bufferOps.add(r);
            }
            check = matcher.find();
            check1 = matcher1.find();
        }
        if (bufferNum.size() == bufferOps.size()) {
            bufferOps.remove(0);
            bufferNum.set(0,bufferNum.get(0)*(-1));
        }
        boolean ord1 = true;
        char oper = ' ';
        int index = 0;
        while (!bufferOps.isEmpty()) {
            if (ord1) {
                for (int i = 0; i < bufferOps.size(); i++) {
                    if (i == bufferOps.size()-1) {
                        ord1 = false;
                    }
                    if (bufferOps.get(i) == '*' || bufferOps.get(i) == '/') {
                        oper = bufferOps.get(i);
                        bufferOps.remove(i);
                        index = i;
                        break;
                    }
                }
            }
            else {
                for (int k = 0; k < bufferOps.size(); k++) {
                    if (bufferOps.get(k) == '+' || bufferOps.get(k) == '-') {
                        oper = bufferOps.get(k);
                        bufferOps.remove(k);
                        index = k;
                        break;
                    }
                }
            }
            if (oper == '*') {
                bufferNum.set(index+1, bufferNum.get(index)*bufferNum.get(index+1));
                bufferNum.remove(index);
            }
            if (oper == '/') {
                if (bufferNum.get(index+1) != 0) {
                    bufferNum.set(index+1, bufferNum.get(index)/bufferNum.get(index+1));
                    bufferNum.remove(index);
                }
                else {
                    return "произошло деление на ноль";
                }
            }
            if (oper == '+') {
                bufferNum.set(index+1, bufferNum.get(index)+bufferNum.get(index+1));
                bufferNum.remove(index);
            }
            if (oper == '-') {
                bufferNum.set(index+1, bufferNum.get(index)-bufferNum.get(index+1));
                bufferNum.remove(index);
            }
        }
        return bufferNum.get(0).toString();
    }
    public static String findLCS(String x, String y) {
        int lx = x.length();
        int ly = y.length();
        StringBuilder res = new StringBuilder();
        char[] xArr = x.toCharArray();
        char[] yArr = y.toCharArray();
        int[][] dyn = new int[lx][ly];
        int[][] max = new int[lx][ly];
        if (xArr[0] == yArr[0]) {
            dyn[0][0] = 1;
            max[0][0] = 1;
        }
        for (int i = 1; i < lx; i++) {
            if (xArr[i] == yArr[0]) {
                dyn[i][0] = 1;
                max[i][0] = 1 + max[i-1][0];
            }
        }
        for (int i = 1; i < ly; i++) {
            if (xArr[0] == yArr[i]) {
                dyn[0][i] = 1;
                max[0][i] = 1 + max[0][i-1];
            }
        }
        for (int i = 1; i < lx; i++) {
            for (int j = 1; j < ly; j++) {
                if (xArr[i] == yArr[j]) {
                    dyn[i][j] = 1;
                    max[i][j] = 1 + Math.max(max[i][j-1], max[i-1][j]);
                }
            }
        }
        int i = 0;
        int j = 0;
        while (i < lx && j < ly) {
            if (dyn[i][j] == 1) {
                res.append(xArr[i]);
                i++;
                j++;
            }
            else if (i != lx-1 && max[i+1][j] > max[i][j]) {
                i++;
            }
            else {
                j++;
            }
        }
        return res.toString();
    }
    public static String nicoCipher(String word,String keysString) {
        char[] key = keysString.toCharArray();
        int indexOf = 0;
        HashMap<Character,ArrayList<Character>> map = new HashMap<Character,ArrayList<Character>>();
        for (char c : key) {
            map.put(c, new ArrayList<Character>());
        }
        for (int i = 0; i < word.length(); i++) {
            if (indexOf == key.length) {
                indexOf = 0;
            }
            map.get(key[indexOf]).add(word.charAt(i));
            indexOf++;
        }
        int maxdepth = map.get(key[0]).size();
        for (char c : key) {
            if (maxdepth > map.get(c).size()) {
                map.get(c).add(' ');
            }
        }
        int[] vals = new int[key.length];
        for (int i = 0; i < key.length; i++) {
            vals[i] = Character.getNumericValue(key[i]);
        }

        for (int i = 0; i < vals.length; i++) {
            int buffer = vals[i];
            char buffer1 = key[i];
            int min = vals[i];
            char minKey = key[i];
            int index = i;
            for (int j = i+1; j < vals.length; j++) {
                if (min > vals[j]) {
                    min = vals[j];
                    minKey = key[j];
                    index = j;
                }
            }
            vals[i] = min;
            vals[index] = buffer;
            key[i] = minKey;
            key[index] = buffer1;
        }
        StringBuilder res = new StringBuilder();
        int depth = 0;
        while (maxdepth > depth) {
            for (int i = 0; i < key.length; i++) {
                res.append(map.get(key[i]).get(depth));
            }
            depth++;
        }
        return res.toString();
    }
}
