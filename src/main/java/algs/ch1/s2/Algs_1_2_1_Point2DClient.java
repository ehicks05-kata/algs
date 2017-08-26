package algs.ch1.s2;

/*
    1.2.1

    Write a  Point2D client that takes an integer value N from the command line,
    generates N random points in the unit square, and computes the distance separating
    the closest pair of points.
* */

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Algs_1_2_1_Point2DClient
{
    public static void main(String[] args)
    {
        int n = 1000;
        
        List<Point2D> points = new ArrayList<>();
        for (int i = 0; i < n; i++)
            points.add(new Point2D(StdRandom.uniform(), StdRandom.uniform()));

        for (Point2D point2D : points)
            StdDraw.point(point2D.x(), point2D.y());

        double minDistance = Double.MAX_VALUE;
        Point2D closest1 = new Point2D(0, 0);
        Point2D closest2 = new Point2D(0, 0);
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
            {
                double distance = points.get(i).distanceTo(points.get(j));
                if (distance < minDistance)
                {
                    minDistance = distance;
                    closest1 = points.get(i);
                    closest2 = points.get(j);
                    StdDraw.setPenColor(Color.blue);
                    StdDraw.line(closest1.x(), closest1.y(), closest2.x(), closest2.y());
                }
            }

        StdDraw.setPenColor(Color.green);
        StdDraw.setPenRadius(StdDraw.getPenRadius() * 10);
        StdDraw.point(closest1.x(), closest1.y());
        StdDraw.point(closest2.x(), closest2.y());
        StdDraw.setPenRadius();
        StdDraw.line(closest1.x(), closest1.y(), closest2.x(), closest2.y());

        System.out.println("distance separating closest pair: " + minDistance);
    }
}
