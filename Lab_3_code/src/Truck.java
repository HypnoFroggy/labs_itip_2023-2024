class Truck extends Auto {
    public int getWheels() {
        return this.wheels;
    }
    private double height;
    private double maxWeight;
    public double getHeight() {
        return this.height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getMaxWeight() {
        return this.maxWeight;
    }
    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }
    public boolean fits(double height) {
        return this.height < height;
    }
    public boolean fits(int people) {
        return this.salon + 16 < height;
    }
    public boolean lifts(double weight) {
        return this.maxWeight > weight;
    }
    public Truck() {
        this.height = 3;
        this.maxWeight = 5000;
    }
}
