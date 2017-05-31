package algs;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

public class Main
{
    public static void main(String[] args)
    {
        int n = Integer.valueOf(args[0]);
        double lo = Double.valueOf(args[1]);
        double hi = Double.valueOf(args[2]);
        double barLogicalWidth = (hi - lo) / n;
        double[] doubles = StdIn.readAllDoubles();

        int[] barHeights = new int[n];

        for (double myDouble : doubles)
        {
            int index = (int) (myDouble / barLogicalWidth);
            barHeights[index]++;
        }

        int largestHeight = 0;
        for (int barHeight : barHeights)
            if (barHeight > largestHeight)
                largestHeight = barHeight;

        StdDraw.setScale(-.1, 1.1); // padding
        double canvasWidth = 1;
        double rectWidth = canvasWidth / n;
        for (int i = 0; i < barHeights.length; i++)
        {
            double barHeight = barHeights[i];
            double x = (rectWidth/2) + (i * rectWidth);
            double y = (barHeight / largestHeight) / 2;
            double halfWidth = rectWidth / 4;
            StdDraw.filledRectangle(x, y, halfWidth, y);
        }
    }
}