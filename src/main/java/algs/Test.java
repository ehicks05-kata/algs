package algs;

import edu.princeton.cs.algs4.StdRandom;

public class Test
{
    public static void main(String[] args)
    {
        double lo = 0;
        double hi = 0;
        while (true)
        {
            double next = StdRandom.gaussian();
            if (next < lo)
            {
                lo = next;
                System.out.println("lo " + lo);
            }
            if (next > hi)
            {
                hi = next;
                System.out.println("hi " + hi);
            }
        }
    }
}