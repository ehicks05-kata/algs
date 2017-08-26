package algs.ch1.s1;

/*
    1.1.22  Write a version of  BinarySearch that uses the recursive  rank() given on page
    25 and traces the method calls. Each time the recursive method is called, print the argu-
    ment values  lo and  hi , indented by the depth of the recursion. Hint: Add an argument
    to the recursive method that keeps track of the depth.
*/

import edu.princeton.cs.algs4.StdRandom;

public class Algs_1_1_22_RecursiveBinarySearch
{
    public static void main(String[] args)
    {
        int length = Integer.MAX_VALUE - 2;
        int[] a = new int[length];
        for (int i = 0; i < length; i++)
            a[i] = i;
        int key = StdRandom.uniform(length);
        System.out.println("key: " + key);
        System.out.println(indexOf(a, key));;
    }

    public static int indexOf(int[] a, int key)
    {
        return indexOf(a, key, 0, a.length - 1, 0);
    }

    public static int indexOf(int[] a, int key, int lo, int hi, int depth)
    {
        String trace = "";
        for (int i = 0; i < depth; i++)
            trace += "  ";

        System.out.println(trace + "lo: " + lo + ", hi: " + hi);
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return indexOf(a, key, lo, mid - 1, ++depth);
        if (key > a[mid]) return indexOf(a, key, mid + 1, hi, ++depth);
        else return mid;
    }
}
