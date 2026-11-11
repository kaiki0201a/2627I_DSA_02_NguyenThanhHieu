package BT_TH;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Point {
    double x, y;
    Point(double x, double y){
        this.x = x;
        this.y = y;
    }
}

public class MinimumDistanceBetwwenTwoPoints {
    // Distance between two points
    static double dist(Point a, Point b){
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    // Brute force for smal cases as base case of recursive
    static double bruteForce(List<Point> pts){
        double min = Double.MAX_VALUE;

        for (int i = 0; i < pts.size(); i++){
            for (int j = i + 1; j < pts.size(); j++){
                min = Math.min(min, dist(pts.get(i), pts.get(j)));
            }
        }

        return min;
    }

    /*
    A utility function to find the distance between the closest points of
    strip of a given size. All points in strip[] are sorted according to y coordinate.
    They all have an upper bound on minimum distance as d.
     */

    static double stripClosest(List<Point> strip, double d){
        double min = d;

        strip.sort(Comparator.comparingDouble(p -> p.y));

        for (int i = 0; i < strip.size(); i++){
            for (int j = i + 1; j < strip.size() && (strip.get(j).y - strip.get(i).y) < min; j++){
                min = Math.min(min, dist(strip.get(i), strip.get(j)));
            }
        }

        return min;
    }

    /*
    A recursive function to find the smallest distance.
    The array Px contains all points sorted according to x coordinates and
    Py contains all points sorted according to y coordinates.
     */

    static double closestUtil(List<Point> pts){
        int n = pts.size();

        if (n <= 3) return bruteForce(pts);

        int mid = n/2;

        Point midPoint = pts.get(mid);

        double dl = closestUtil(pts.subList(0, mid));
        double dr = closestUtil(pts.subList(mid, n));

        double d = Math.min(dl, dr);

        List<Point> strip = new ArrayList<>();
        for (Point p : pts){
            if (Math.abs(p.x - midPoint.x) < d)
                strip.add(p);
        }

        return Math.min(d, stripClosest(strip, d));
    }

    static double closest(List<Point> points) {
        points.sort(Comparator.comparingDouble(p -> p.x));
        return closestUtil(points);
    }


}
