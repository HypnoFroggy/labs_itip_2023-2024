import java.io.File;
import java.util.Scanner;
public class ArrayAverage {
    public static void main(String[] args) throws Exception {
        try {
            int[] array = new int[14];
            File myFile = new File("C:/Users/user/Desktop/универ/Прога/lab_5_code/src/txt.txt");
            Scanner scanner = new Scanner(myFile);
            int index = 0;
            while (scanner.hasNextLine()) {
                array[index] = Integer.parseInt(scanner.nextLine());
                index++;
            }
            
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                sum += array[i];
                System.out.println(array[i]);
                
            }
            double mid = sum / array.length;
            System.out.println(mid);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("out of bounds lol");
        }
        catch (java.lang.NumberFormatException e) {
            System.out.println("неверные данные");
        }
    }
}
