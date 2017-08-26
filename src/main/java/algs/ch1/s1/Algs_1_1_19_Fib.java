package algs.ch1.s1;

import java.time.LocalDateTime;

/*
    1.1.19 Run the following program on your computer:

    public class Fibonacci
    {
        public static long F(int N)
        {
            if (N == 0) return 0;
            if (N == 1) return 1;
            return F(N-1) + F(N-2);
        }
        public static void main(String[] args)
        {
            for (int N = 0; N < 100; N++)
            StdOut.println(N + " " + F(N));
        }
    }

    What is the largest value of  N for which this program takes less 1 hour to compute the
    value of  F(N) ? Develop a better implementation of  F(N) that saves computed values in
    an array

    Answer: 59 is the last number that takes less than an hour (i5 3570k @ 4GHz)
*/

public class Algs_1_1_19_Fib
{
    public static void main(String[] args)
    {
        for (int n = 0; n < 90; n++)
            System.out.println(LocalDateTime.now().toString() +
                    " " + n + " " + topDownFib(n));
        System.out.println();
        for (int n = 0; n < 90; n++)
            System.out.println(LocalDateTime.now().toString() +
                    " " + n + " " + bottomUpDynamicFib(n));
    }

    static long[] fibs = new long[91];
    public static long topDownFib(int n)
    {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (fibs[n] > 0) return fibs[n];
        fibs[n] = topDownFib(n-1) + topDownFib(n-2);
        return fibs[n];
    }

    public static long bottomUpDynamicFib(int n)
    {
        if (n == 0) return 0;
        if (n == 1) return 1;
        long[] f = new long[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++)
            f[i] = f[i-1] + f[i-2];
        return f[n];
    }
}