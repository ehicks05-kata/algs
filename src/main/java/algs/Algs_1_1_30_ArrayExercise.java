package algs;

/*
    1.1.30 Array exercise.

    Write a code fragment that creates an N-by-N boolean array
    a[][] such that  a[i][j] is  true if  i and  j are relatively prime (have no common fac-
    tors), and  false otherwise.
* */

public class Algs_1_1_30_ArrayExercise
{
    public static void main(String[] args)
    {
        int n = 10;
        boolean[][] a = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
            {
                a[i][j] = gcd(i, j) == 1;
            }

        Algo.print2DArray(a);
    }

    public static int gcd(int p, int q)
    {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }
}
