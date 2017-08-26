package algs.ch1.s1;

/*
  1.1.35 Dice simulation

    The value dist[i] is the probability that the dice sum to  k . Run experiments to vali-
    date this calculation simulating N dice throws, keeping track of the frequencies of oc-
    currence of each value when you compute the sum of two random integers between 1
    and 6. How large does N have to be before your empirical results match the exact results
    to three decimal places?
*/

import edu.princeton.cs.algs4.StdRandom;

public class Algs_1_1_35_DiceSimulation
{
    public static void main(String[] args)
    {
        double[] dist = getExpectedDist();
        double[] myDist = new double[13];

        int[] rawResults = new int[13];
        for (int n = 0; n < 100_000_000; n++)
        {
            int die1 = StdRandom.uniform(1, 7);
            int die2 = StdRandom.uniform(1, 7);
            int sum = die1 + die2;
            rawResults[sum]++;

            updateMyDist(myDist, rawResults);
            if (isEqualDists(myDist, dist, .0001))
            {
                System.out.println("distributions were equal after " + n + " rolls");
                break;
            }
        }
    }

    public static boolean isEqualDists(double[] myDist, double[] dist, double eps)
    {
        for (int i = 0; i < myDist.length; i++)
        {
            double myProportion = myDist[i];
            double expected = dist[i];
            boolean equal = Math.abs(myProportion - expected) < eps;
            if (!equal)
                return false;
        }
        return true;
    }

    public static void updateMyDist(double[] myDist, int[] rawResults)
    {
        int totalResults = 0;
        for (int rawResult : rawResults)
            totalResults += rawResult;

        for (int i = 0; i < rawResults.length; i++)
        {
            double proportion = (double) rawResults[i] / totalResults;
            myDist[i] = proportion;
        }
    }
    
    public static double[] getExpectedDist()
    {
        int SIDES = 6;
        double[] dist = new double[2*SIDES+1];
        for (int i = 1; i <= SIDES; i++)
            for (int j = 1; j <= SIDES; j++)
                dist[i+j] += 1.0;
        for (int k = 2; k <= 2*SIDES; k++)
            dist[k] /= 36.0;
        return dist;
    }
}
