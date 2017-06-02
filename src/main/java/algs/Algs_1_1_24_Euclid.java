package algs;

/*
    1.1.24  Give the sequence of values of p and q that are computed when Euclid’s algo-
    rithm is used to compute the greatest common divisor of 105 and 24. Extend the code
    given on page 4 to develop a program Euclid that takes two integers from the command
    line and computes their greatest common divisor, printing out the two arguments for
    each call on the recursive method. Use your program to compute the greatest common
    divisor or 1111111 and 1234567.

    Answer:

    gcd(105, 24)
	24 9
	 9 6
	 6 3
	 3 0
	returns 3
*/

import edu.princeton.cs.algs4.StdOut;

public class Algs_1_1_24_Euclid
{
    public static void main(String[] args)
    {
        int p = Integer.valueOf(args[0]);
        int q = Integer.valueOf(args[1]);

        StdOut.println(gcd(p, q));
    }

    public static int gcd(int p, int q)
    {
        StdOut.println("p: " + p + ", q: " + q);
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }
}
