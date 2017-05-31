package algs;

/*
    1.1.39 Random matches.

    Write a  BinarySearch client that takes an  int value  T as
    command-line argument and runs T trials of the following experiment for N = 10 3 , 10 4 ,
    10 5 , and 10 6 : generate two arrays of N randomly generated positive six-digit  int values,
    and find the number of values that appear in both arrays. Print a table giving the average
    value of this quantity over the T trials for each value of N.
*/

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class BinarySearchClient
{
    public static void main(String[] args)
    {
        int t = 10;
        int[] nSizes = new int[]{1_000, 10_000, 100_000, 1_000_000};

        for (int nSizeIndex = 0; nSizeIndex < nSizes.length; nSizeIndex++)
        {
            int totalMatches = 0;
            int n = nSizes[nSizeIndex];

            for (int trial = 0; trial < t; trial++)
            {
                int[] array1 = new int[n];
                int[] array2 = new int[n];
                for (int i = 0; i < n; i++)
                {
                    array1[i] = StdRandom.uniform(100_000, 1_000_000);
                    array2[i] = StdRandom.uniform(100_000, 1_000_000);
                }

                Arrays.sort(array2);

                int matches = 0;
                for (int i = 0; i < n; i++)
                    if (binarySearchRank(array1[i], array2) > -1)
                        matches++;

                totalMatches += matches;
            }

            double averageMatches = (double) totalMatches / t;
            System.out.println("n of " + n + ": average matches: " + averageMatches);
        }
    }

    public static int binarySearchRank(int key, int[] a)
    { // Array must be sorted.
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi)
        { // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}
