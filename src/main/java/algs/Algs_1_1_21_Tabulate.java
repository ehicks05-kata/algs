package algs;

/*
    1.1.21  Write a program that reads in lines from standard input with each line contain-
    ing a name and two integers and then uses  printf() to print a table with a column of
    the names, the integers, and the result of dividing the first by the second, accurate to
    three decimal places. You could use a program like this to tabulate batting averages for
    baseball players or grades for students.
*/

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Algs_1_1_21_Tabulate
{
    public static void main(String[] args)
    {
        while (!StdIn.isEmpty())
        {
            String name = StdIn.readString();
            int n1 = StdIn.readInt();
            int n2 = StdIn.readInt();

            StdOut.printf("%10s %5d %5d %7.3f", name, n1, n2, ((double) n1 / n2));
        }
    }
}
