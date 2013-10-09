import java.io.*;
import java.lang.*;

class Point {
    double x = 0;
    double y = 0;
    String name = "";
    double distanceToClosest = 0.0;
    Point closest = null;

    public Point(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
}

public class DistancePointToPoint {
    public static void main(String []args) {
        Point[] points = new Point[]{new Point("point1", 3, 4), new Point("point2", 101, 201), new Point("point3", 100, 200)};

        for(int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                double num = Math.sqrt(Math.pow((points[j].x - points[i].x),2) + Math.pow((points[j].y - points[i].y), 2));

                if ((points[i].closest == null || points[i].closest.name != points[j].name) &&
                        (num != 0.0) && (points[i].distanceToClosest > num || points[i].distanceToClosest == 0.0)) {
                    points[i].closest = points[j];
                    points[i].distanceToClosest = num;
                }
            }
        }


        Point point = null;
        for (int k = 0; k < points.length; k++) {
            if (point == null || points[k].distanceToClosest < point.distanceToClosest) {
                point = points[k];
            }
        }
        System.out.println(point.name + " is closest to " + point.closest.name);
    }
}
