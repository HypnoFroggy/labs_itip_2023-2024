public class App {
    public static void main(String[] args) {
        Motorcycle f = new Motorcycle(0, false);
        System.out.println(Motorcycle.count);
        System.out.println(f.getBrand());
        f.setBrand("porsche");
        System.out.println(f.getBrand());
        System.out.println(f.getRide());
        f.repair();
        Auto a = new Auto();
        a.setPower(300);
        System.out.println(a.getPower());
        System.out.println(a.fits(1111));
        Truck t = new Truck();
        System.out.println(t.fits(5000.1));
        System.out.println(t.fits(50));
    }
}