import java.util.Arrays;

public class ArraySum {
    public static void main(String[] args) {
        int[] myArray = {1,2,3,4,5,6,7,8,9,10};
        int[] a = Arrays.copyOfRange(myArray, 0, myArray.length/2);
        int[] b = Arrays.copyOfRange(myArray, myArray.length/2, myArray.length);
        SyncData sum1 = new SyncData(0);
        SyncData sum2 = new SyncData(0);
        ArrayThread thread1 = new ArrayThread(a, sum1);
        ArrayThread thread2 = new ArrayThread(b, sum2);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sum1.getData()+sum2.getData());
    }
}
