package hw7;

public class Circle extends Shape{
    private int radius;

    public int getRadius() {
        return radius;
    }

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void getName(){
        System.out.println("this is Circle with radius equals " + getRadius() + "cm");
    }
}
