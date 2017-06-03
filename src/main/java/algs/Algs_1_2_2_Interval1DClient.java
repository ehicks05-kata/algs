package algs;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdRandom;

/*
    1.2.2 Write an Interval1D client that takes an int value N as command-line argu-
    ment, reads N intervals (each defined by a pair of double values) from standard input,
    and prints all pairs that intersect.
* */

public class Algs_1_2_2_Interval1DClient
{
    public static void main(String[] args)
    {
        int n = 5;

        Interval1D[] intervals = new Interval1D[n];
        for (int i = 0; i < n; i++)
        {
            double lo = StdRandom.uniform();
            double hi = StdRandom.uniform();
            while (lo >= hi)
            {
                lo = StdRandom.uniform();
                hi = StdRandom.uniform();
            }
            intervals[i] = new Interval1D(lo, hi);
        }

        for (int i = 0; i < n; i++)
            for (int j = i+1; j < n; j++)
            {
                if (intervals[i].intersects(intervals[j]))
                    System.out.println(intervals[i] + " " + intervals[j]);
            }
    }
}