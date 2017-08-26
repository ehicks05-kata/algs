package algs.ch1.s1;

public class Algs_1_1_13
{
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
}