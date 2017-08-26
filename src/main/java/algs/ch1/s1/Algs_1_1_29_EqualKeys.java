package algs.ch1.s1;

/*
    1.1.29 Equal keys.

    Add to  BinarySearch a static method  rank() that takes a key and
    a sorted array of  int values (some of which may be equal) as arguments and returns the
    number of elements that are smaller than the key and a similar method  count() that
    returns the number of elements equal to the key. Note : If  i and  j are the values returned
    by  rank(key, a) and  count(key, a) respectively, then  a[i..i+j-1 ] are the values in
    the array that are equal to  key
* */

import edu.princeton.cs.algs4.BinarySearch;

import java.util.Arrays;

public class Algs_1_1_29_EqualKeys
{
    public static void main(String[] args)
    {
        int[] numbers = new int[]{23, 52, 14, 25, 14, 4, 12, 66, 23, 26};

        Arrays.sort(numbers);

        int i = 0;
        for (int input : numbers)
        {
            System.out.println("index: " + i++ + ", " + input + " rank: " + rank(numbers, input) + " count: " + count(numbers, input));
        }

    }

    public static int rank(int[] a, int key)
    {
        int index = BinarySearch.indexOf(a, key);
        if (index == -1) return -1;
        for (int i = index - 1; i >= 0; i--)
            if (a[i] != key)
                return i + 1;
        return 0;
    }

    public static int count(int[] a, int key)
    {
        int index = BinarySearch.indexOf(a, key);
        if (index == -1) return -1;
        int minMatchIndex = index;
        int maxMatchIndex = index;
        while (minMatchIndex > 0 && a[minMatchIndex - 1] == a[index])
            minMatchIndex--;
        while (minMatchIndex < a.length - 1 && a[maxMatchIndex + 1] == a[index])
            maxMatchIndex++;

        return 1 + maxMatchIndex - minMatchIndex;
    }

    private static int[] removeDupes(int[] whitelist)
    {
        int j = 0;
        int[] noDupes = new int[whitelist.length];
        for (int i = 0; i < whitelist.length; i++)
            if (i == 0 || noDupes[j - 1] != whitelist[i])
                noDupes[j++] = whitelist[i];
        whitelist = Arrays.copyOf(noDupes, j);
        return whitelist;
    }
}
