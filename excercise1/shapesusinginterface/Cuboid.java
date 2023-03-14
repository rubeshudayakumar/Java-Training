package dayThree.daythree.excercise2;

public class Cuboid extends Square implements CalcVolume{

    public Cuboid(int side) {
        super(side);
    }

    @Override
    public float calculateSurfaceArea() {
        return 6*side*side;
    }

    @Override
    public float calculateVolume() {
        return side*side*side;
    }
    
}
