public class MatrixThread extends Thread{
    private int[] array;
    private SyncData sync;
    MatrixThread(int[] array, SyncData sync) {
        this.array = array;
        this.sync = sync; 
    }
    public void run(){
        for (int i = 0; i < array.length; i++) {
            sync.add(array[i]);
        }
    }
}