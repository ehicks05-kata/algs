package algs;

import edu.princeton.cs.algs4.StdRandom;

public class Algs_1_1_11
{
    public static void main(String[] args)
    {
        boolean[][] array = new boolean[6][6];
        for (int row = 0; row < array.length; row++)
            for (int col = 0; col < array.length; col++)
            {
                array[row][col] = StdRandom.bernoulli();
            }

            print2DArray(array);
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
}