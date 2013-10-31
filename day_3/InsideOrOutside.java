import java.io.*;

public class InsideOrOutside {
    Rectangle rec = null;

    public InsideOrOutside(Rectangle rec) {
        this.rec = rec;
    }

    public boolean isWithin(Point point) {
        if(rec.upLeft.x > point.x && rec.downRight.x < point.x) {
            if(rec.upLeft.y > point.y && rec.downRight.y < point.y) {
                return true;
            }
        }
        return false;
    }

    public static void main(String []args) {
        InsideOrOutside insideOrOutside = new InsideOrOutside(new Rectangle(new Point("point1", 5,6), new Point("point2", 1,2)));

        Point point1 = new Point("point1", 3,4);
        Point point2 = new Point("point2", 7,8);

        System.out.println(insideOrOutside.isWithin(point1));
        System.out.println(insideOrOutside.isWithin(point2));
    }
}
