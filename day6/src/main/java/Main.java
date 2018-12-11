import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        partOne("test.txt");
//        partOne("input.txt");

    }

    private static void partOne(String filename) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream(filename));
        List<Point2D> points = new ArrayList<>();
        while (scanner.hasNext()){
            String[] inputString = scanner.nextLine().split(", ");
            Point2D point = new Point(Integer.parseInt(inputString[0]), Integer.parseInt(inputString[1]));
            points.add(point);
        }
        Polygon polygon = new Polygon();
        for (Point2D point : points){
            polygon.addPoint((int)point.getX(), (int) point.getY());
            System.out.println(point);
        }
        System.out.println(polygon.getBounds());

    }
}
