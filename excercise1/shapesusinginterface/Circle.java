package dayThree.daythree.excercise2;

public class Circle implements CalcArea{
    public static final float pi = 3.14f;

    public int r;

    public Circle(int r){
        this.r = r;
    }

    @Override
    public float calculateArea() {
        return pi*this.r*this.r;
    }

    @Override
    public float calculatePerimeter() {
       return 2*pi*r;
    }

}
