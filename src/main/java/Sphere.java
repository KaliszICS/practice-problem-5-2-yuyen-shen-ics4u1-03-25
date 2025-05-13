class Sphere extends Circle {

    protected double radius;

    public Sphere(double radius) {
        super(radius);
        this.radius = radius; //set radius field in Sphere
    }

    @Override
    public double area() {
        return this.radius * this.radius * 4.0 * Math.PI;
    }


    @Override
    public double volume() {
        return 4.0 / 3.0 * Math.PI * Math.pow(this.radius, 3);
    }
}
