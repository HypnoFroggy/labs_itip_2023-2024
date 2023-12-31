public class CheckAction implements Runnable {
    private PorterThread porter1;
    private PorterThread porter2;
    private PorterThread porter3;
    private SyncData f;
    public CheckAction(PorterThread porter1, PorterThread porter2, PorterThread porter3,SyncData f) {
        this.porter1 = porter1;
        this.porter2 = porter2;
        this.porter3 = porter3;
        this.f = f;
    }
    public void run() {
        int a = porter1.get();
        int b = porter2.get();
        int c1 = porter3.get();
        int f1 = f.getData();
        while (a + b + c1 > 150) {
            System.out.println("Произошел перегруз");
            if (a + b > 150) {
                porter2.set(150 - a);
                b = 150 - a;
            }
            else if (c1 - (150 - a - b) < 0) {
                porter3.set(0);
                c1 = 0;
            }
            else {
                porter3.set((150 - a - b));
                c1 = (150 - a - b);
            }
            System.out.println("Теперь грузчики взяли по: " + a + ", " + b + ", " + c1);
        }
        while (f1 < a + b + c1) {
            System.out.println("Грузчики решили оставить склад1 с отрицательным значением, так не пойдет");
            if (f1 - b - c1 >= 0) {
                a = f1 - b - c1;
                porter1.set(a);
            } else {
                a = 0;
                porter1.set(0);
                b = f1 - c1;
                if (b < 0) {
                    b = 0;
                    c1 = f1;
                }
                porter2.set(b);
                porter3.set(c1);
                if (f1 < a + b + c1) {
                    System.out.println("durak");
                }
            }
            System.out.println("Теперь грузчики взяли по: " + a + ", " + b + ", " + c1);
        }
    }
}
