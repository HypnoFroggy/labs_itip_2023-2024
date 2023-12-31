class Motorcycle extends Vehicle{
    public int getWheels() {
        return this.wheels;
    }
    private double safety;
    public double getSafety() {
        return this.safety;
    }
    public void setSafety(double safety) {
        this.safety = safety;
    }
    private boolean isUncrashed;
    public void repair() {
        this.isUncrashed = true;
    }
    public String getRide() {
        if (!isUncrashed) {
            return "CRASHED ALREADY";
        }
        if (this.safety >= Math.random()) {
            return "SUCCESS";
        }
        else {
            this.isUncrashed = false;
            return "CRASHED";
        }
    }
    public Motorcycle() {
        this.setWheels(2);
        count += 1;
        this.safety = 0.5;
        this.isUncrashed = true;
    }
    public Motorcycle(double safety) {
        this.setWheels(2);
        count += 1;
        this.safety = safety;
        this.isUncrashed = true;
    }
    public Motorcycle(boolean isUncrashed) {
        this.setWheels(2);
        count += 1;
        this.safety = 0.5;
        this.isUncrashed = isUncrashed;
    }
    public Motorcycle(double safety, boolean isUncrashed) {
        this.setWheels(2);
        count += 1;
        this.safety = 0.5;
        this.isUncrashed = true;
    }
    public static int count;
}