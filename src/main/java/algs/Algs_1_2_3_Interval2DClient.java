package algs;

import edu.princeton.cs.algs4.*;

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
            StdDraw.text(hor.min() - .01, ver.max() + .01, ""+i);
            intervals[i] = rect;
        }

        for (int i = 0; i < n; i++)
            for (int j = i+1; j < n; j++)
            {
                Interval2D i1 = intervals[i];
                Interval2D i2 = intervals[j];
                if (i1.intersects(i2))
                    System.out.println(i1 + " " + i + " intersects " + j + " " + i2);

                String[] i1horVerPair = i1.toString()
                        .replaceAll("\\[","")
                        .replaceAll("]","")
                        .split(" x ");
                String[] i1HorCoordPair = i1horVerPair[0].split(", ");
                String[] i1VerCoordPair = i1horVerPair[1].split(", ");
                double i1xlo = Double.parseDouble(i1HorCoordPair[0]);
                double i1xhi = Double.parseDouble(i1HorCoordPair[1]);
                double i1ylo = Double.parseDouble(i1VerCoordPair[0]);
                double i1yhi = Double.parseDouble(i1VerCoordPair[1]);

                String[] i2horVerPair = i2.toString()
                        .replaceAll("\\[","")
                        .replaceAll("]","")
                        .split(" x ");
                String[] i2HorCoordPair = i2horVerPair[0].split(", ");
                String[] i2VerCoordPair = i2horVerPair[1].split(", ");
                double i2xlo = Double.parseDouble(i2HorCoordPair[0]);
                double i2xhi = Double.parseDouble(i2HorCoordPair[1]);
                double i2ylo = Double.parseDouble(i2VerCoordPair[0]);
                double i2yhi = Double.parseDouble(i2VerCoordPair[1]);

                boolean horContained = i1xlo < i2xlo && i1xhi > i2xhi;
                boolean verContained = i1ylo < i2ylo && i1yhi > i2yhi;
                if (horContained && verContained)
                    System.out.println(i1 + " " + i + " contains " + j + " " + i2);
            }
    }
}