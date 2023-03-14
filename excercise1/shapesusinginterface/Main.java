package dayThree.daythree.excercise2;

public class Main {
    public static void main(String[] args) {
        Circle c = new Circle(5);

        System.out.println("<-----Circle object created----->");
        System.out.println("Area of circle : "+c.calculateArea());
        System.out.println("Perimeter of circle : "+c.calculatePerimeter());

        Square s = new Square(5);
        System.out.println("<-----Square object created----->");
        System.out.println("Area of circle : "+s.calculateArea());
        System.out.println("Perimeter of circle : "+s.calculatePerimeter());

        Triangle t = new Triangle(3, 3, 3);
        System.out.println("<-----Triangle---->");
        System.out.println(t.calculateArea());
        System.out.println(s.calculatePerimeter());

        Sphere sp = new Sphere(5);
        System.out.println("<-----Sphere object created----->");
        System.out.println(sp.calculateArea());
        System.out.println(sp.calculatePerimeter());
        System.out.println(sp.calculateSurfaceArea());
        System.out.println(sp.calculateVolume());

        Cuboid cu = new Cuboid(5);
        System.out.println("<-----Cuboid object created----->");
        System.out.println(cu.calculateArea());
        System.out.println(cu.calculatePerimeter());
        System.out.println(cu.calculateSurfaceArea());
        System.out.println(cu.calculateVolume());

    }
}
