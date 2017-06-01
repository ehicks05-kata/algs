package algs;

/*
    1.1.28 Remove duplicates.

    Modify the test client in  BinarySearch to remove any du-
    plicate keys in the whitelist after the sort.
*/

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Algs_1_1_28_RemoveDuplicates
{
    public static void main(String[] args)
    {
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();

        boolean printMissingItems = args[1].equals("+");
        boolean printFoundItems = args[1].equals("-");

        Arrays.sort(whitelist);

        int j = 0;
        int[] noDupes = new int[whitelist.length];
        for (int i = 0; i < whitelist.length; i++)
            if (i == 0 || noDupes[j - 1] != whitelist[i])
                noDupes[j++] = whitelist[i];
        whitelist = Arrays.copyOf(noDupes, j);

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
