package algs;

public class Algs_1_1_15
{
    public static int[] histogram(int[] a, int m)
    {
        int[] histo = new int[m];

        for (int i = 0; i < a.length; i++)
            if (a[i] < m)
                histo[a[i]]++;

        return histo;
    }
}