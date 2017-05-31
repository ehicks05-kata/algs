package algs;

/*
    1.1.38 Binary search versus brute-force search

    Write a program  BruteForceSearch
    that uses the brute-force search method given on page 48 and compare its running time
    on your computer with that of  BinarySearchClient for  largeW.txt and  largeT.txt
*/

import edu.princeton.cs.algs4.In;

import java.io.File;
import java.util.Arrays;

public class BruteForceSearch
{
    public static void main(String[] args)
    {
        int[] whitelist = new In(new File("largeW.txt")).readAllInts();
        int[] targetList = new In(new File("largeT.txt")).readAllInts();

        Arrays.sort(whitelist);

        long start = System.currentTimeMillis();
        int found = 0;
        for (int i = 0; i < targetList.length; i++)
        {
            if (i % 100_000 == 0)
                System.out.println(i);
            int target = targetList[i];
            if (bruteRank(target, whitelist) > -1)
                found++;
        }
        System.out.println("found " + found + " entries in " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        found = 0;
        for (int i = 0; i < targetList.length; i++)
        {
            if (i % 100_000 == 0)
                System.out.println(i);
            int target = targetList[i];
            if (binarySearchRank(target, whitelist) > -1)
                found++;
        }
        System.out.println("found " + found + " entries in " + (System.currentTimeMillis() - start) + " ms");
    }

    public static int bruteRank(int key, int[] a)
    {
        for (int i = 0; i < a.length; i++)
            if (a[i] == key) return i;
        return -1;
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
