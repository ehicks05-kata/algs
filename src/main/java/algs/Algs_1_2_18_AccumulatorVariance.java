package algs;

/*
    1.2.18 Variance for accumulator. Validate that the following code, which adds the
    methods  var() and  stddev() to  Accumulator , computes both the mean and variance
    of the numbers presented as arguments to  addDataValue() :

    public class Accumulator
    {
        private double m;
        private double s;
        private int N;
        public void addDataValue(double x)
        {
            N++;
            s = s + 1.0 * (N-1) / N * (x - m) * (x - m);
            m = m + (x - m) / N;
        }
        public double mean()
        { return m; }
        public double var()
        { return s/(N - 1); }
        public double stddev()
        { return Math.sqrt(this.var()); }
    }

    This implementation is less susceptible to roundoff error than the straightforward im-
    plementation based on saving the sum of the squares of the numbers.
* */

import edu.princeton.cs.algs4.StdRandom;

public class Algs_1_2_18_AccumulatorVariance
{
    public static void main(String[] args) throws Exception
    {
        int n = 100;
        double[] array = new double[n];
        Accumulator accumulator = new Accumulator();

        double total = 0;
        for (int i = 0; i < n; i++)
        {
            double d = StdRandom.uniform();
            total += d;
            array[i] = d;
            accumulator.addDataValue(d);
        }
        
        double mean = total / n;

        double var = 0;
        for (double a : array)
            var += (a - mean) * (a - mean);
        var = var / (n - 1);

        double stddev = Math.sqrt(var);

        System.out.println("my mean:   " + mean);
        System.out.println("my var:    " + var);
        System.out.println("my stddev: " + stddev);
        System.out.println();
        System.out.println("mean:   " + accumulator.mean());
        System.out.println("var:    " + accumulator.var());
        System.out.println("stddev: " + accumulator.stddev());
    }

    public static class Accumulator
    {
        private double m;
        private double s;
        private int N;
        public void addDataValue(double x)
        {
            N++;
            s = s + 1.0 * (N-1) / N * (x - m) * (x - m);
            m = m + (x - m) / N;
        }

        public double mean()
        {
            return m;
        }

        public double var()
        {
            return s / (N - 1);
        }

        public double stddev()
        {
            return Math.sqrt(this.var());
        }
    }
}
