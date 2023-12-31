class Car {
    private String brand;
    private String model;
    private int year;
    Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    public void info(){
        System.out.println("#########");
        System.out.println("brand: " + brand);
        System.out.println("model: " + model);
        System.out.println("year: " + year);
        System.out.println("#########");
    }
}
