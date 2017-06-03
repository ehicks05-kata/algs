package algs;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/*
    1.2.3 Write an Interval2D client that takes command-line arguments N , min , and max
    and generates N random 2D intervals whose width and height are uniformly distributed
    between min and max in the unit square. Draw them on StdDraw and print the number
    of pairs of intervals that intersect and the number of intervals that are contained in one
    another.
* */

public class Algs_1_2_3_Interval2DClient
{
    public static void main(String[] args)
    {
        int n = 5;
        double min = 0.1;
        double max = 0.9;

        Interval2D[] intervals = new Interval2D[n];
        for (int i = 0; i < n; i++)
        {
            double lox = StdRandom.uniform();
            double hix = StdRandom.uniform();
            while (lox >= hix)
            {
                lox = StdRandom.uniform(min, max);
                hix = StdRandom.uniform(min, max);
            }
            Interval1D hor = new Interval1D(lox, hix);
            double loy = StdRandom.uniform(min, max);
            double hiy = StdRandom.uniform(min, max);
            while (loy >= hiy)
            {
                loy = StdRandom.uniform(min, max);
                hiy = StdRandom.uniform(min, max);
            }
            Interval1D ver = new Interval1D(loy, hiy);
            Interval2D rect = new Interval2D(hor, ver);
            rect.draw();
            intervals[i] = rect;
        }

        for (int i = 0; i < n; i++)
            for (int j = i+1; j < n; j++)
            {
                if (intervals[i].intersects(intervals[j]))
                    System.out.println(intervals[i] + " " + intervals[j]);
//                if (intervals[i].intersects(intervals[j]))
//                    System.out.println(intervals[i] + " " + intervals[j]);

            }
    }
}