package algs.ch1.s1;

import algs.Common;

public class Algs_1_1_33_Matrix
{
    public static void main(String[] args)
    {
        double[] x = new double[]{1,  3, 4};
        double[] y = new double[]{2, -1, 5};
        System.out.println("Dot Product:");
        System.out.println(dot(x, y));

        double[][] a = new double[][] {{ 1, 2, 3},
                                       { 4, 5, 6}};

        double[][] b = new double[][] {{ 7, 8},
                                       { 9, 10},
                                       {11, 12}};

        System.out.println("\r\nMatrix-Matrix Product:");
        Common.print2DArray(mult(a, b));

        System.out.println("\r\nMatrix-Vector Product:");
        Common.print2DArray(mult(a, x));

        System.out.println("\r\nVector-Matrix Product:");
        Common.print2DArray(mult(x, b));
    }

    // vector dot product
    public static double dot(double[] x, double[] y)
    {
        int len = x.length;
        double sum = 0;
        for (int i = 0; i < len; i++)
            sum += x[i] * y[i];
        return sum;
    }

    // matrix-matrix product
    public static double[][] mult(double[][] a, double[][] b)
    {
        int aRows = a.length;
        int bRows = b.length;
        int aCols = a[0].length;
        int bCols = b[0].length;

        if (aCols != bRows)
            return null;

        double[][] result = new double[aRows][bCols];

        for (int i = 0; i < aRows; i++)
            for (int j = 0; j < bCols; j++)
            {
                double[] column = new double[bRows];
                for (int c = 0; c < b.length; c++)
                    column[c] = b[c][j];

                result[i][j] = dot(a[i], column);
            }

        return result;
    }

    // transpose
    public static double[][] transpose(double[][] a)
    {
        int m = a.length;
        int n = a[0].length;

        double[][] transposed = new double[n][m];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                transposed[j][i] = a[i][j];

        return transposed;
    }

    // matrix-vector product (special case of matrix-matrix product)
    public static double[] mult(double[][] a, double[] x)
    {
        double[][] xAsOneColumnMatrix = new double[x.length][1];
        for (int i = 0; i < x.length; i++)
            xAsOneColumnMatrix[i][0] = x[i];

        double[][] matrixMatrixResult = mult(a, xAsOneColumnMatrix);

        // our answer will only have one column
        double[] answer = new double[matrixMatrixResult.length];
        for (int i = 0; i < matrixMatrixResult.length; i++)
            answer[i] = matrixMatrixResult[i][0];
        return answer;
    }

    // vector-matrix product
    public static double[] mult(double[] y, double[][] a)
    {
        double[][] yAsOneRowMatrix = new double[1][y.length];
        for (int i = 0; i < y.length; i++)
            yAsOneRowMatrix[0][i] = y[i];

        double[][] matrixMatrixResult = mult(yAsOneRowMatrix, a);

        // our answer will only have one row
        double[] answer = new double[matrixMatrixResult[0].length];
        for (int i = 0; i < matrixMatrixResult[0].length; i++)
            answer[i] = matrixMatrixResult[0][i];
        return answer;
    }
}