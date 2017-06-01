package algs;

/*
    1.1.27 Binomial distribution.

    Estimate the number of recursive calls that would be
    used by the code
    public static double binomial(int N, int k, double p)
    {
        if ((N == 0) || (k < 0)) return 1.0;
        return (1.0 - p)*binomial(N-1, k) + p*binomial(N-1, k-1);
    }
    to compute  binomial(100, 50) . Develop a better implementation that is based on
    saving computed values in an array.
*/

import edu.princeton.cs.algs4.StdOut;

public class Algo_1_1_27_BinomialDistribution
{
    // slow
    public static double binomial1(int N, int k, double p) {
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;
        return (1.0 - p) *binomial1(N-1, k, p) + p*binomial1(N-1, k-1, p);
    }

    // memoization
    public static double binomial2(int N, int k, double p) {
        double[][] b = new double[N+1][k+1];

        // base cases
        for (int i = 0; i <= N; i++)
            b[i][0] = Math.pow(1.0 - p, i);
        b[0][0] = 1.0;

        // recursive formula
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= k; j++) {
                b[i][j] = p * b[i-1][j-1] + (1.0 - p) *b[i-1][j];
            }
        }
        return b[N][k];
    }

    public static void main(String[] args) {
        int N = 100;
        int k = 50;
        double p = 0.25;
        StdOut.println(binomial2(N, k, p));
    }
}
