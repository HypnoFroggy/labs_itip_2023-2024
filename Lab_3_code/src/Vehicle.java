abstract class Vehicle {
    private String brand;
    public String getBrand() {
        return this.brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    private int power;
    public int getPower() {
        return this.power;
    }
    public void setPower(int power) {
        this.power = power;
    }
    protected  int wheels;
    public abstract int getWheels();
    public void setWheels(int wheels) {
        this.wheels = wheels;
    }
    public Vehicle() {
        brand = "unknown";
        power = 100;
        wheels = 4;
    }
}
