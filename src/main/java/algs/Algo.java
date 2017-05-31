package algs;

public class Algo
{
    public static boolean[][] populateBooleanArray(int m, int n)
    {
        boolean[][] array = new boolean[m][n];
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[0].length; j++)
                array[i][j] = Math.random() > 0.5;
        return array;
    }

    public static boolean[][] transpose(boolean[][] array)
    {
        int m = array.length;
        int n = array[0].length;

        boolean[][] transposed = new boolean[n][m];

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                transposed[j][i] = array[i][j];
            }
        }
        return transposed;
    }

    public static void print2DArray(boolean[][] array)
    {
        int m = array.length;
        int n = array[0].length;

        String spaceForLabels = " ";
        String trueIcon = "*";
        int longestSize = Math.max(m, n);
        while (longestSize >= 1)
        {
            spaceForLabels += " ";
            trueIcon = " " + trueIcon;
            longestSize /= 10;
        }

        System.out.print(spaceForLabels); // push column labels over to make room for row labels
        for (int i = 0; i < n; i++)
        {
            String colLabel = "" + i;
            while (colLabel.length() < spaceForLabels.length())
                colLabel = " " + colLabel;
            System.out.print(colLabel); // print col label
        }
        System.out.println();

        for (int i = 0; i < m; i++)
        {
            String rowLabel = "" + i;
            while (rowLabel.length() < spaceForLabels.length())
                rowLabel = " " + rowLabel;
            System.out.print(rowLabel); // print row label

            for (int j = 0; j < n; j++)
            {
                System.out.print(array[i][j] ? trueIcon : spaceForLabels);
            }
            System.out.println();
        }
    }

    public static int[] histogram(int[] a, int m)
    {
        int[] histo = new int[m];

        for (int i = 0; i < a.length; i++)
            if (a[i] < m)
                histo[a[i]]++;

        return histo;
    }
}
