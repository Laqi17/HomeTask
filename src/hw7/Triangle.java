package hw7;

public class Triangle extends Shape{
    private int sideOne;
    private int sideTwo;
    private int angle;

    public Triangle(int sideOne, int sideTwo, int angle) {
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
        this.angle = angle;
    }

    public int getSideOne() {
        return sideOne;
    }

    public int getSideTwo() {
        return sideTwo;
    }

    public int getAngle() {
        return angle;
    }

    @Override
    public void getName() {
        System.out.println("this is Triangle with first side equals " + getSideOne() + "cm, second side " + getSideTwo() + "cm and angle between sides " + getAngle() + "degree");
    }
}
