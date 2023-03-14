package dayThree.daythree.excercise2;

public class Triangle implements CalcArea{
    public int a,b,c;

    public Triangle(int a,int b,int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public float calculateArea() {
        int s = (this.a+this.b+this.c)/2;
        float area =  (float)Math.sqrt((s*(s-a)*(s-b)*(s-c)));
        return area;
    }

    @Override
    public float calculatePerimeter() {
        return this.a+this.b+this.c;
    }
}
