package dayThree.daythree.excercise2;

public class Square implements CalcArea{
    public int side;

    public Square(int side){
        this.side = side;
    }

    @Override
    public float calculateArea() {
        return this.side*this.side;
    }

    @Override
    public float calculatePerimeter() {
      return 4*this.side;
    }
    
}
