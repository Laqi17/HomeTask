package hw7;

public class Rectangle extends Shape{
    private int height;
    private int width;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public void getName() {
        System.out.println("this is Rectangle with sides " + getHeight() + "cm and " + getWidth() + "cm");
    }
}
