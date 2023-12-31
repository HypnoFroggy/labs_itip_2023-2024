class Auto extends Vehicle {
    public int getWheels() {
        return this.wheels;
    }
    protected int salon;
    public double getSalon() {
        return this.salon;
    }
    public void setSalon(int salon) {
        this.salon = salon;
    }
    public boolean fits(int people) {
        return this.salon > people;
    }
    public void plusWheel() {
        this.wheels++;
    }
    public Auto() {
        salon = 4;
    }
}