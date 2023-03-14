package dayThree.daythree.excercise2;

public class Sphere extends Circle implements CalcVolume {

    public Sphere(int r) {
        super(r);
    }

    @Override
    public float calculateSurfaceArea() {
        return 4*pi*r*r;
    }

    @Override
    public float calculateVolume() {
        return (4/3)*pi*r*r*r;
    }
}
