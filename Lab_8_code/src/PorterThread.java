import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.CyclicBarrier;

public class PorterThread extends Thread{
    private int carries;
    private int serialNumber;
    private SyncData from;
    private SyncData where;
    private CyclicBarrier c;
    public PorterThread(int n, SyncData from, SyncData where) {
        serialNumber = n;
        this.from = from;
        this.where = where;
        carries = 0;
    }
    public synchronized void setCyclic(CyclicBarrier c) {
        this.c = c;
    }
    public int carry() {
        carries = ThreadLocalRandom.current().nextInt(0, 150 + 1);
        return carries;
    }
    public int get() {
        return carries;
    }
    public synchronized void set(int set) {
        carries = set;
    }
    public void define() {
        from.add(carries * (-1));
        where.add(carries);
    }
    public void run(){
        while (from.getData() > 0) {
            System.out.println("Грузчик номер " + serialNumber + " взял " + carry());
            try {
                c.await();
            } catch (Exception exc) {
                System.out.println(exc);
            }
            define();
            try {
                Thread.sleep(100);
            } catch (Exception exc) {
                System.out.println(exc);
            }
        }
    }
}
