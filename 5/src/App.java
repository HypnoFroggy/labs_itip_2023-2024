import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(sameLetterPattern("nnll", "2122"));
        System.out.println(spiderVsFly("H3", "E2"));
        System.out.println(digitsCount(1111));
        String[] arr = {"qwe","rt2y","wert","qerwy"};
        System.out.println(totalPoints(arr, "qwerty"));
        int[] array = {1,6,5,4,8,2,3,7};
        int[][] result = sumsUp(array);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
        String[] a = {"12%","32%","22%","59%"};
        System.out.println(takeDownAverage(a));
        System.out.println(caesarCipher("decode", "abcde", 2));
        System.out.println(setSetup(7,3));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));
        System.out.println(isNew(321));
    }
    public static boolean sameLetterPattern(String string1, String string2) {
        HashMap<Character,Character> map = new HashMap<Character,Character>();
        char[] s1 = string1.toCharArray();
        char[] s2 = string2.toCharArray();
        for (int i = 0; i < s1.length;i++) {
            if(!map.containsKey(s1[i])) {
                map.put(s1[i], s2[i]);
            } 
            else {
                if(s2[i] != map.get(s1[i])) {
                    return false;
                }
            }
        }
        return true;
    }
    public static String spiderVsFly(String string1, String string2) {
        String res = "";
        ArrayList<Character> listx = new ArrayList<Character>();
        listx.add('A');
        listx.add('B');
        listx.add('C');
        listx.add('D');
        listx.add('E');
        listx.add('F');
        listx.add('G');
        listx.add('H');
        int x1 = listx.indexOf(string1.charAt(0));
        int x2 = listx.indexOf(string2.charAt(0));
        int y1 = Integer.parseInt(string1.substring(1));
        int y2 = Integer.parseInt(string2.substring(1));

        if (Math.abs(x1-x2) == 4 || Math.abs(x1-x2) == 3 || Math.abs(x1-x2) == 5) {
            for (int i = y1; i >= 0; i--) {
                res += string1.charAt(0) + "" + i + " ";
            }
            for (int i = 1; i <= y2; i++) {
                res += string2.charAt(0) + "" + i + " ";
            }
        }

        if (Math.abs(x1-x2) == 0 && y1 <= y2) {
            for (int i = y1; i <= y2; i++) {
                res += string1.charAt(0) + "" + i + " ";
            }
        }
        if (Math.abs(x1-x2) == 0 && y1 > y2) {
            for (int i = y1; i >= y2; i--) {
                res += string1.charAt(0) + "" + i + " ";
            }
        }

        if (Math.abs(x1-x2) < 3 && y1 <= y2 && x1 <= x2) {
            for (int i = x1; i <= x2; i++) {
                res += listx.get(i) + "" + y1 + " ";
            }
            for (int i = y1+1; i <= y2; i++) {
                res += string2.charAt(0) + "" + i + " ";
            }
        }
        if (Math.abs(x1-x2) < 3 && y1 > y2 && x1 <= x2) {
            for (int i = y1; i >= y2; i--) {
                res += string1.charAt(0) + "" + i + " ";
            }
            for (int i = x1+1; i <= x2; i++) {
                res += listx.get(i) + "" + y2 + " ";
            }
        }

        if (Math.abs(x1-x2) < 3 && y1 <= y2 && x1 > x2) {
            for (int i = x1; i >= 0; i--) {
                res += listx.get(i) + "" + y1 + " ";
            }
            for (int i = 0; i < x2; i++) {
                res += listx.get(i) + "" + y1 + " ";
            }
            for (int i = y1+1; i <= y2; i++) {
                res += string2.charAt(0) + "" + i + " ";
            }
        }
        if (Math.abs(x1-x2) < 3 && y1 > y2 && x1 > x2) {
            for (int i = y1; i > y2; i--) {
                res += string1.charAt(0) + "" + i + " ";
            }
            for (int i = x1; i >= 0; i--) {
                res += listx.get(i) + "" + y2 + " ";
            }
            for (int i = 0; i < x2; i++) {
                res += listx.get(i) + "" + y2 + " ";
            }
        }

        if (Math.abs(x1-x2) > 5 && y1 <= y2 && x1 <= x2) {
            //System.out.println(1);
            for (int i = x1; i >= 0; i--) {
                res += listx.get(i) + "" + y1 + " ";
            }
            for (int i = 7; i >= x2; i--) {
                res += listx.get(i) + "" + y1 + " ";
            }
            for (int i = y1+1; i <= y2; i++) {
                res += string2.charAt(0) + "" + i + " ";
            }
        }
        if (Math.abs(x1-x2) > 5 && y1 > y2 && x1 <= x2) {
            // System.out.println(2);
            for (int i = y1; i >= y2; i--) {
                res += string1.charAt(0) + "" + i + " ";
            }
            for (int i = x1-1; i >= 0; i--) {
                res += listx.get(i) + "" + y2 + " ";
            }
            for (int i = 7; i >= x2; i--) {
                res += listx.get(i) + "" + y2 + " ";
            }
        }

        if (Math.abs(x1-x2) > 5 && y1 <= y2 && x1 > x2) {
            // System.out.println(3);
            for (int i = x1; i <= 7; i++) {
                res += listx.get(i) + "" + y1 + " ";
            }
            for (int i = 0; i > x2; i++) {
                res += listx.get(i) + "" + y1 + " ";
            }
            for (int i = y1+1; i <= y2; i++) {
                res += string2.charAt(0) + "" + i + " ";
            }
            
        }
        if (Math.abs(x1-x2) > 5 && y1 > y2 && x1 > x2) {
            // System.out.println(4);
            for (int i = y1; i > y2; i--) {
                res += string1.charAt(0) + "" + i + " ";
            }
            for (int i = x1; i <= 7; i++) {
                res += listx.get(i) + "" + y2 + " ";
            }
            for (int i = 0; i <= x2; i++) {
                res += listx.get(i) + "" + y2 + " ";
            }
        }
        res = res.trim().replaceAll(" ", "-");
        return res;
    }
    public static int digitsCount(int a) {
        if (a <= 9 && a >= 0) {
            return 1;
        }
        return 1 + digitsCount(a / 10);
    }
    public static int totalPoints(String[] words, String hidden) {
        int res = 0;
        ArrayList<Character> hiddenChars = new ArrayList<Character>();
        ArrayList<Integer> hiddenCount = new ArrayList<Integer>();
        ArrayList<Character> wordChars = new ArrayList<Character>();
        ArrayList<Integer> wordCount = new ArrayList<Integer>();
        for (int i = 0; i < hidden.length(); i++) {
            if (hiddenChars.contains(hidden.charAt(i))) {
                hiddenCount.set(hiddenChars.indexOf(hidden.charAt(i)),hiddenCount.get(hiddenChars.indexOf(hidden.charAt(i)))+1);
            }
            else {
                hiddenChars.add(hidden.charAt(i));
                hiddenCount.add(1);
            }
        }
        for (String word : words) {
            boolean assertTrue = true;
            for (int i = 0; i < word.length(); i++) {
                if (wordChars.contains(word.charAt(i))) {
                    wordCount.set(wordChars.indexOf(word.charAt(i)),wordCount.get(wordChars.indexOf(word.charAt(i)))+1);
                }
                else {
                    wordChars.add(word.charAt(i));
                    wordCount.add(1);
                }
            }
            for (int i = 0; i < word.length(); i++) {
                if (hiddenChars.contains(word.charAt(i))) {
                    wordCount.set(wordChars.indexOf(word.charAt(i)),wordCount.get(wordChars.indexOf(word.charAt(i)))+1);
                }
                else {
                    assertTrue = false;
                }
            }
            if (assertTrue) {
                if (word.length() == 6) {
                    res += 54;
                }
                else {
                    res += word.length() - 2;
                }
            }
            wordChars.clear();
            wordCount.clear();
        }
        return res;
    }
    public static int[][] sumsUp(int[] array) {
        ArrayList<int[]>[] list = new ArrayList[9];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<int[]>();
        }
        int paircount = 0;
        for (int index = 0; index < array.length; index++) {
            for (int index1 = index+1; index1 < array.length; index1++) {
                if(array[index]+array[index1]==8){
                    int[] b = {array[index],array[index1]};
                    // System.out.println(Arrays.toString(b));
                    list[index].add(b);
                    paircount++;
                }
            }
        }
        int count = 0;
        int[][] res = new int[paircount][2];
        for (int index = 0; index < list.length; index++) {
            for (int index1 = 0; index1 < list[index].size(); index1++) {
                res[count] = list[index].get(index1);
                count++;
            }
        }
        return res;
    }
    public static String takeDownAverage(String[] args) {
        // String res = "";
        int s = 0;
        int n = args.length;
        for (String str : args) {
            Pattern pattern = Pattern.compile("[0-9]+");
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                s += Integer.parseInt(matcher.group());
            }
        }
        int x = (int)Math.round(((double)s/(double)n - 5)*(n+1)-s);
        return x + "%";
    }
    public static String caesarCipher(String mode, String str, int shift) {
        str = str.toUpperCase();
        String res = "";
        if (mode.equals("encode")) {
            for (char c : str.toCharArray()) {
                int i = (int)c;
                if (i >= 65 && i <= 90) {
                    i -= 65;
                    i = (i + shift)%26;
                    i += 65;
                    res += (char)i;
                }
                else {
                    res += c;
                }
            }
        }
        if (mode.equals("decode")) {
            for (char c : str.toCharArray()) {
                int i = (int)c;
                if (i >= 65 && i <= 90) {
                    i -= 90;
                    i = (i - shift)%26;
                    i += 90;
                    res += (char)i;
                }
                else {
                    res += c;
                }
            }
        }
        
        return res;
    }
    public static int setSetup(int n, int k) {
        if (k==0) {
            return 1;
        }
        if (k>n) {
            return 0;
        }
        return setSetup(n-1, k) + k * setSetup(n-1, k-1);
    }
    public static String timeDifference(String cityA, String timeString, String cityB) {
        // Объявляем то, с чем будем работать
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("Los Angeles", "00:00");
        map.put("New York", "03:00");
        map.put("Caracas", "03:30");
        map.put("Buenos Aires", "05:00");
        map.put("London", "08:00");
        map.put("Rome", "09:00");
        map.put("Moscow", "11:00");
        map.put("Tehran", "11:30");
        map.put("New Delhi", "13:30");
        map.put("Beijing", "16:00");
        map.put("Canberra", "18:00");
        HashMap<Integer,Integer> monthmap = new HashMap<Integer,Integer>();
        monthmap.put(1, 31);
        monthmap.put(2, 28);
        monthmap.put(3, 31);
        monthmap.put(4, 30);
        monthmap.put(5, 31);
        monthmap.put(6, 30);
        monthmap.put(7, 31);
        monthmap.put(8, 31);
        monthmap.put(9, 30);
        monthmap.put(10, 31);
        monthmap.put(11, 30);
        monthmap.put(12, 31);
        HashMap<String,Integer> monthorderMap = new HashMap<String,Integer>();
        monthorderMap.put("January", 1);
        monthorderMap.put("February", 2);
        monthorderMap.put("March", 3);
        monthorderMap.put("April", 4);
        monthorderMap.put("May", 5);
        monthorderMap.put("June", 6);
        monthorderMap.put("July", 7);
        monthorderMap.put("August", 8);
        monthorderMap.put("September", 9);
        monthorderMap.put("October", 10);
        monthorderMap.put("November", 11);
        monthorderMap.put("December", 12);
        String buffer = "";
        int mins = 0;
        int hours = 0;
        int days = 0;
        int mths = 0;
        int years = 0;
        int hoursMod = 0;
        int daysMod = 0;
        int yearsMod = 0;
        int minsA = 0;
        int hoursA = 0;
        int minsB = 0;
        int hoursB = 0;

        // Подтягиваем время по часам и минутам

        Pattern pattern = Pattern.compile("[0-9]+:[0-9]+");
        Matcher matcher = pattern.matcher(timeString);
        if (matcher.find()) {
            buffer = matcher.group();
            timeString = timeString.replaceAll(matcher.group(),"");
        }
        pattern = Pattern.compile("[0-9]+");
        matcher = pattern.matcher(buffer);
        if (matcher.find()) {
            hours = Integer.parseInt(matcher.group());
        }
        if (matcher.find()) {
            mins = Integer.parseInt(matcher.group());
        }

        // Здесь вычисляем время для городов А и Б

        matcher = pattern.matcher(map.get(cityA));
        if (matcher.find()) {
            hoursA = Integer.parseInt(matcher.group());
        }
        if (matcher.find()) {
            minsA = Integer.parseInt(matcher.group());
        }
        matcher = pattern.matcher(map.get(cityB));
        if (matcher.find()) {
            hoursB = Integer.parseInt(matcher.group());
        }
        if (matcher.find()) {
            minsB = Integer.parseInt(matcher.group());
        }

        // Здесь вычисляем время и модификаторы

        mins += minsB - minsA;
        while (mins < 0) {
            mins += 60;
            hoursMod--;
        }
        while (mins >= 60) {
            mins -= 60;
            hoursMod++;
        }
        hours += hoursB - hoursA + hoursMod;
        while (hours < 0) {
            hours += 24;
            daysMod--;
        }
        while (hours >= 24) {
            hours -= 24;
            daysMod++;
        }

        // Теперь ищем день и месяц

        pattern = Pattern.compile("[0-9]+,");
        matcher = pattern.matcher(timeString);
        if (matcher.find()) {
            days = Integer.parseInt(matcher.group().replace(",", ""));
            timeString = timeString.replaceAll(matcher.group(),"");
        }
        pattern = Pattern.compile("\\b[A-Za-z]+");
        matcher = pattern.matcher(timeString);
        if (matcher.find()) {
            mths = monthorderMap.get(matcher.group());
            timeString = timeString.replaceAll(matcher.group(),"");
        }

        // И вычисляем день нормально и одновременно прокатываем месяцы и изменяем модификаторы года

        days += daysMod;
        while (days <= 0) {
            mths--;
            if (mths < 1) {
                yearsMod--;
                mths = 12;
            }
            days += monthmap.get(mths);
        }
        while (days >= monthmap.get(mths)) {
            mths++;
            if (mths > 12) {
                yearsMod++;
                mths = 1;
            }
            days -= monthmap.get(mths);
        }

        // Читаем и вычисляем год

        pattern = Pattern.compile("[0-9]+");
        matcher = pattern.matcher(timeString);
        if (matcher.find()) {
            years = Integer.parseInt(matcher.group());
        }
        years += yearsMod;

        // Результирующая строка

        buffer = "";
        if (hours < 10) {
            buffer += "0";
        }
        buffer += hours + ":";
        if (mins < 10) {
            buffer += "0";
        }
        buffer += mins;
        String res = years + "-" + mths + "-" + days + " " + buffer;

        return res;
    }
    public static boolean isNew(int a) {
        if (a == 0) {
            return true;
        }
        HashMap<Integer,Integer> chars = new HashMap<Integer,Integer>();
        String numA = a + "";
        for (char i : numA.toCharArray()) {
            int c = Integer.parseInt(i+"");
            if (chars.containsKey(c)) {
                chars.replace(c, chars.get(c)+1);
            }
            else {
                chars.put(c, 1);
            }
        }
        String numB = "";
        for (int i = 0; i < numA.length(); i++) {
            int k = 0;
            if (i == 0) {
                k = 1;
            }
            for (int j = k; j < 10; j++) {
                if (chars.containsKey(j)) {
                    if (chars.get(j) > 0) {
                        numB += j;
                        chars.replace(j, chars.get(j)-1);
                        break;
                    }
                }
            }
        }
        int b = Integer.parseInt(numB);
        return b >= a;
    }
}
