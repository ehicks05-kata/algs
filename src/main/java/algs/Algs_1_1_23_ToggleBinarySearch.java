package algs;

/*
    1.1.23  Add to the  BinarySearch test client the ability to respond to a second argu-
    ment:  + to print numbers from standard input that are not in the whitelist,  - to print
    numbers that are in the whitelist.
*/

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Algs_1_1_23_ToggleBinarySearch
{
    public static void main(String[] args)
    {
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();

        boolean printMissingItems = args[1].equals("+");
        boolean printFoundItems = args[1].equals("-");

        Arrays.sort(whitelist);

        while (!StdIn.isEmpty())
        {
            int key = StdIn.readInt();
            int index = BinarySearch.indexOf(whitelist, key);
            boolean printIt = (printMissingItems && index == -1) || (printFoundItems && index != -1);
            if (printIt)
                StdOut.println(key);
        }
    }
}
