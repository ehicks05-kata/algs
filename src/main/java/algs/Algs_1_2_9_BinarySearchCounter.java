package algs;

/*
    1.2.9  Instrument  BinarySearch (page 47) to use a  Counter to count the total number
    of keys examined during all searches and then print the total after all searches are com-
    plete. Hint : Create a  Counter in  main() and pass it as an argument to  rank().
* */

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Algs_1_2_9_BinarySearchCounter
{
    public static void main(String[] args)
    {
        int arraySize = 1000;
        int range = 1000;
        int searchesToRun = 1000;
        for (int i = 0; i < searchesToRun; i++)
            runASearch(arraySize, range);
    }

    private static void runASearch(int arraySize, int range)
    {
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++)
            array[i] = StdRandom.uniform(range);

        Arrays.sort(array);

        Counter counter = new Counter("keys examined");
        int rank = rank(StdRandom.uniform(range), array, counter);
        System.out.printf("rank: %4d, %s\r\n", rank, counter);
    }

    public static int rank(int key, int[] a, Counter counter)
    { // Array must be sorted.
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi)
        { // Key is in a[lo..hi] or not present.
            counter.increment();
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}
