import java.util.concurrent.*;
public class Porter {
    public static void main(String[] args) throws Exception {
        SyncData storage1 = new SyncData(1000);
        SyncData storage2 = new SyncData(0);
        PorterThread porter1 = new PorterThread(1, storage1, storage2);
        PorterThread porter2 = new PorterThread(2, storage1, storage2);
        PorterThread porter3 = new PorterThread(3, storage1, storage2);
        CyclicBarrier BARRIER = new CyclicBarrier(3, new CheckAction(porter1, porter2, porter3,storage1));
        porter1.setCyclic(BARRIER);
        porter2.setCyclic(BARRIER);
        porter3.setCyclic(BARRIER);
        porter1.start();
        porter2.start();
        porter3.start();
        Thread.sleep(5000);
        System.out.println("Грузчики переместили " + storage2.getData());
        System.out.println("Грузчики оставили " + storage1.getData());
    }
}