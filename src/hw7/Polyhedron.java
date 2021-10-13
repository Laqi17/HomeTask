package hw7;

public class Polyhedron extends Shape{
    private int sideLength;
    private int numberOfSides;

    public int getSideLength() {
        return sideLength;
    }

    public int getNumberOfSides() {
        return numberOfSides;
    }

    public Polyhedron(int sideLength, int numberOfSides) {
        this.sideLength = sideLength;
        this.numberOfSides = numberOfSides;
    }

    @Override
    public void getName() {
        System.out.println("this is Polyhedron, with side length equals " + getSideLength() + "cm and number of sides equals " + getNumberOfSides());
    }
}
