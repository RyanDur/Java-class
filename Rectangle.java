import java.io.*;

public class Rectangle {
    Point upLeft;
    Point downRight;

    public Rectangle(Point upLeft, Point downRight) {
        this.upLeft = upLeft;
        this.downRight = downRight;
    }

    public static void main(String []args) {
        Rectangle rec = new Rectangle(new Point("point1", 5,6), new Point("point2", 1,2));

        double height = rec.upLeft.y - rec.downRight.y;
        double width = rec.upLeft.x - rec.downRight.x;

        System.out.println("the area is " + height*width);
        System.out.println("the perimeter is " + (2*height + 2*width));
    }
}
