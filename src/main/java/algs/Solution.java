package algs;

public class Solution {
    public static void main(String[] args)
    {
        double x = 2.00000;
        int n = -2147483648;

        System.out.println(myPow(x, n));
    }

    public static double myPow(double x, int n) {
        if (x == 1)
            return 1;

        boolean negN = n < 0;
        n = Math.abs(n);
        double answer = 1;
        while (n-- > 0)
        {
            answer *= x;
            if (answer == 0)
                return 0;
        }

        if (negN)
            answer = 1 / answer;
        return answer;
    }
}