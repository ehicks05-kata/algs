package algs;

import java.time.LocalDateTime;

public class Fib
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