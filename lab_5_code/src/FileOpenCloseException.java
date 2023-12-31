import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.io.IOException;
public class FileOpenCloseException {
    public static void main(String[] args) throws Exception {
        File myFile = new File("C:/Users/user/Desktop/универ/Прога/lab_5_code/src/txt.txt");
        File anotherFile = new File("C:/Users/user/Desktop/универ/Прога/lab_5_code/src/text.txt");
        try {
            FileInputStream input = new FileInputStream(myFile);
            FileOutputStream output = new FileOutputStream(anotherFile);
            byte[] buffer = new byte[100];
            for (int index = 0; index < buffer.length; index++) {
                buffer[index] = ' ';
            }
            input.read(buffer);
            output.write(buffer);
            input.close();
            output.close();
        } catch (FileNotFoundException e) {
            // System.out.println("Не нашли файл" + e);
            throw new CustomFileNotFoundException("Не нашли файл");
        } catch (SecurityException e) {
            System.out.println("Ошибка доступа" + e);
        } 
        // catch (IOException e) {
        //     System.out.println("Ошибка ввода или вывода в файл" + e);
        // } 
        
    }
}
