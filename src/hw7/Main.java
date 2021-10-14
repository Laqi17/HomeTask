package hw7;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape quad =  new Quad(5);
        Shape rectangle = new Rectangle(8, 5);
        Shape triangle = new Triangle(5, 12, 45);
        Shape polyhedron =  new Polyhedron(5, 12);

        Util.printName(circle);
    }
}
