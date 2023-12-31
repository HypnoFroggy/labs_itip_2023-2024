import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Uchet {
    public static void main(String[] args) {
        int sum = 0;
        ConcurrentHashMap<String,AtomicInteger> uchetnayaKniga = new ConcurrentHashMap<String,AtomicInteger>();
        uchetnayaKniga.put("salt", new AtomicInteger(2));
        uchetnayaKniga.get("salt").getAndIncrement();
        uchetnayaKniga.get("salt").addAndGet(9);
        uchetnayaKniga.put("ball", new AtomicInteger(4));
        for (String k : uchetnayaKniga.keySet()) {
            System.out.println(k + " продано " + uchetnayaKniga.get(k));
            sum += uchetnayaKniga.get(k).intValue();
        }
        System.out.println("Всего продано " + sum);
    }
}
