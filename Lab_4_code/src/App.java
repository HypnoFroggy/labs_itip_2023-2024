public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println(HashTable.hash("Ф"));
        // System.out.println(HashTable.hash("А"));

        HashTable<String,Car> table = new HashTable<String,Car>();

        // Car car = new Car("1", "1", 1);
        // table.put("Ф",car);
        // table.get("Ф").info();
        // Car car1 = new Car("ee", "ee", 4334);
        // table.put("А",car1);
        // table.get("А").info();
        // Car car2 = new Car("2", "2", 2);
        // table.put("Ф",car2);
        // table.get("Ф").info();


        Car car1 = new Car("1", "1", 1);
        Car car2 = new Car("2", "2", 2);
        Car car3 = new Car("3", "3", 3);
        table.put("car1",car1);
        table.put("car2",car2);
        table.put("car3",car3);
        System.out.println(table.size());
        table.remove("car2");
        System.out.println(table.size());
    }
}
