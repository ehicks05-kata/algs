package algs;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/*
    1.1.31 Random connections. 

    Write a program that takes as command-line arguments
    an integer  N and a  double value  p (between 0 and 1), plots  N equally spaced dots of size
    .05 on the circumference of a circle, and then, with probability  p for each pair of points,
    draws a gray line connecting them.
* */

public class Algs_1_1_31_RandomConnections
{
    public static void main(String[] args)
    {
//        int n = Integer.valueOf(args[0]);
//        double p = Double.valueOf(args[1]);
        int n = 5;
        double p = 32;
        double radius = .45;

        Point2D center = new Point2D(0.5, 0.5);
        double degreesBetween = (2 * Math.PI) / n;
        double degrees = 0;
        List<Point2D> points = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            double x = center.x() + radius * Math.cos(degrees);
            double y = center.y() + radius * Math.sin(degrees);
            points.add(new Point2D(x, y));

            degrees += degreesBetween;
        }

        for (Point2D point : points)
            StdDraw.filledCircle(point.x(), point.y(), .05);

        StdDraw.setPenColor(Color.LIGHT_GRAY);
        for (Point2D first : points)
            for (Point2D second : points)
                if (StdRandom.uniform() < p)
                    StdDraw.line(first.x(), first.y(), second.x(), second.y());

        StdDraw.filledCircle(.5, .5, .005);
    }
}
