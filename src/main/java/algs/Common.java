package algs;

public class Common
{
    public static <T> void print2DArray(T[][] array)
    {
        if (array == null)
        {
            System.out.println("null array");
            return;
        }
        
        int m = array.length;
        int n = array[0].length;

        String spaceForLabels = "       ";
        String trueIcon = "*";
        int longestSize = Math.max(m, n);
        while (longestSize >= 1)
        {
            spaceForLabels += " ";
            trueIcon = " " + trueIcon;
            longestSize /= 10;
        }
        String rowLabelPadding = "";
        int rows = m;
        while (rows >= 1)
        {
            rowLabelPadding += " ";
            rows /= 10;
        }

        System.out.print(rowLabelPadding); // push column labels over to make room for row labels
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
            while (rowLabel.length() < rowLabelPadding.length())
                rowLabel = " " + rowLabel;
            System.out.print(rowLabel); // print row label

            for (int j = 0; j < n; j++)
            {
                String value = array[i][j].toString();
                if (value.length() > spaceForLabels.length())
                    value = value.substring(0, spaceForLabels.length());
                while (value.length() < spaceForLabels.length())
                    value = " " + value;
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static <T> void print2DArray(T[] array)
    {
        T[][] xAsOneColumnMatrix = (T[][]) new Object[array.length][1];
        for (int i = 0; i < array.length; i++)
            xAsOneColumnMatrix[i][0] = array[i];

        print2DArray(xAsOneColumnMatrix);
    }

    public static <T> void print2DArray(double[] array)
    {
        Double[] objectArray = new Double[array.length];
        for (int i = 0; i < array.length; i++)
            objectArray[i] = array[i];

        print2DArray(objectArray);
    }

    public static void print2DArray(double[][] array)
    {
        if (array == null)
        {
            System.out.println("null array");
            return;
        }
        
        Double[][] objectArray = new Double[array.length][array[0].length];
        for (int row = 0; row < array.length; row++)
            for (int col = 0; col < array[0].length; col++)
                objectArray[row][col] = array[row][col];

        print2DArray(objectArray);
    }
    public static void print2DArray(int[][] array)
    {
        if (array == null)
        {
            System.out.println("null array");
            return;
        }

        Integer[][] objectArray = new Integer[array.length][array[0].length];
        for (int row = 0; row < array.length; row++)
            for (int col = 0; col < array[0].length; col++)
                objectArray[row][col] = array[row][col];

        print2DArray(objectArray);
    }
}
