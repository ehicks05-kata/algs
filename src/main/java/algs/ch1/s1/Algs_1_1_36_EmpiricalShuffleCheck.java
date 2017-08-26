package algs.ch1.s1;

/*
    1.1.36 Empirical badShuffle check

    Run computational experiments to check that our
    shuffling code on page 32 works as advertised. Write a program  ShuffleTest that takes
    command-line arguments M and N, does N shuffles of an array of size M that is initial-
    ized with  a[i] = i before each badShuffle, and prints an M-by-M table such that row  i
    gives the number of times  i wound up in position  j for all  j . All entries in the array
    should be close to N/M.
*/

import algs.Common;
import edu.princeton.cs.algs4.StdRandom;

public class Algs_1_1_36_EmpiricalShuffleCheck
{
    public static void main(String[] args)
    {
        int m = 6;
        int n = 10_000_000;

        int[][] results = new int[m][m];

        for (int shuffleIndex = 0; shuffleIndex < n; shuffleIndex++)
        {
            int[] array = initializeArray(m);
            shuffle(array);

            for (int i = 0; i < m; i++)
            {
                results[i][array[i]]++;
            }
        }

        Common.print2DArray(results);
        System.out.println();
        String[][] percentDivergence = new String[m][m];
        for (int row = 0; row < m; row++)
            for (int col = 0; col < m; col++)
            {
                double divergence = ((double) results[row][col] / (n / m)) * 100;
                percentDivergence[row][col] = String.format("%.0f", divergence);
            }

        Common.print2DArray(percentDivergence);
    }

    private static int[] initializeArray(int m)
    {
        int[] array = new int[m];
        for (int i = 0; i < m; i++)
            array[i] = i;
        return array;
    }

    public static void shuffle(int[] a)
    {
        int N = a.length;
        for (int i = 0; i < N; i++)
        { // Exchange a[i] with random element in a[i..N-1]
            int r = i + StdRandom.uniform(N - i);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void badShuffle(int[] a)
    {
        int N = a.length;
        for (int i = 0; i < N; i++)
        { // Exchange a[i] with random element in a[i..N-1]
            int r = 0 + StdRandom.uniform(N);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
}
