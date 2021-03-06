package algs.ch1.s3;

/*
    1.3.5  What does the following code fragment print when  N is  50 ? Give a high-level
    description of what it does when presented with a positive integer  N .

    Stack<Integer> stack = new Stack<Integer>();
    while (N > 0)
    {
        stack.push(N % 2);
        N = N / 2;
    }
    for (int d : stack) StdOut.print(d);
        StdOut.println();

    Answer : Prints the binary representation of  N ( 110010 when  N is  50 ).
* */

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Algs_1_3_05_StackPrintout
{
    public static void main(String[] args) throws Exception
    {
        mystery(50);
        mystery(6);
        mystery(Integer.MAX_VALUE);
        mystery(Integer.MIN_VALUE);
    }

    public static void mystery(int N)
    {
        Stack<Integer> stack = new Stack<>();
        while (N > 0)
        {
            stack.push(N % 2);
            N = N / 2;
        }
        for (int d : stack) StdOut.print(d);
        StdOut.println();
    }
}
