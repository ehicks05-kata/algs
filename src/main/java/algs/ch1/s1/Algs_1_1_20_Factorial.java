package algs.ch1.s1;

/*
    1.1.20  Write a recursive static method that computes the value of ln (N !)
*/

public class Algs_1_1_20_Factorial
{
    // Since n! = 1 x 2 x 3 x ... x n,
    //  log(n!) = log(1) + log(2) + log(3) + ... + log(n)
    public static double lnOfFactorial(int n)
    {
        if (n == 0) return Math.log(1);
        if (n == 1) return Math.log(1);
        double[] f = new double[n + 1];
        f[0] = Math.log(1);
        f[1] = Math.log(1);
        for (int i = 2; i <= n; i++)
            f[i] = Math.log(i) + f[i-1];
        return f[n];
    }
}
