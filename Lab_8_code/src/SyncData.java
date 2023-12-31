public class SyncData {
    private int data;
    public SyncData(int data) {
        this.data = data;
    }
    public synchronized void add(int a) {
        data += a;
    }
    public synchronized int getData() {
        return data;
    }
}
