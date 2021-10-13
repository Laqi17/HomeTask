package hw7;

public class Quad extends Shape {
    private int height;

    public int getHeight() {
        return height;
    }

    public Quad(int height) {
        this.height = height;
    }
    @Override
    public void getName() {
        System.out.println("this is Quad with side equals " + getHeight() + "cm");
    }
}
