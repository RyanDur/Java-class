import java.io.*;

public class Overlaps {
    InsideOrOutside inout1 = null;
    InsideOrOutside inout2 = null;

    public Overlaps(InsideOrOutside inout1, InsideOrOutside inout2) {
        this.inout1 = inout1;
        this.inout2 = inout2;
    }

    public void isWithin(Point point) {
        if(inout1.isWithin(point) && inout2.isWithin(point)) {
            System.out.println("It's within both!");
        } else if (inout1.isWithin(point)) {
            System.out.println("It's within the first rectangle only");
        } else if (inout2.isWithin(point)) {
            System.out.println("It's within the second rectangle only");
        } else {
            System.out.println("It's within neither");
        }
    }

    public static void main(String []args) {
        Overlaps overlaps = new Overlaps(new InsideOrOutside(new Rectangle(new Point("point1", 5,6), new Point("point2", 1,2))),
                new InsideOrOutside(new Rectangle(new Point("point3", 12, 11), new Point("point4", 3,4))));

        Point point1 = new Point("point1", 4,5);

        overlaps.isWithin(point1);
    }
}
