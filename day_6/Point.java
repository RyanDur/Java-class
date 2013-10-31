import java.io.*;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
	this.x = x;
	this.y = y;
    }

    public double distanceTo(Point point) {
	return Math.sqrt(Math.pow((point.x - this.x), 2) + Math.pow((point.y - this.y), 2));
    }

    public double distanceToOrigin() {
	return distanceTo(new Point(0,0));
    }

    public void moveTo(double x, double y) {
	this.x = x;
	this.y = y;
    }

    public void moveTo(Point point) {
	this.x = point.x;
	this.y = point.y;
    }

    public Point clone() {
	return new Point(x, y);
    }

    public Point opposite() {
	return new Point((x*-1), (y*-1));
    }
}
