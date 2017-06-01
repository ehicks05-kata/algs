package algs;

/*
1.1.34 Filtering. Which of the following require saving all the values from standard
input (in an array, say), and which could be implemented as a filter using only a fixed
number of variables and arrays of fixed size (not dependent on N)? For each, the input
comes from standard input and consists of N real numbers between 0 and 1.
■  Print the maximum and minimum numbers.
■  Print the median of the numbers.
■  Print the k th smallest value, for k less than 100.
■  Print the sum of the squares of the numbers.
■  Print the average of the N numbers.
■  Print the percentage of numbers greater than the average.
■  Print the N numbers in increasing order.
■  Print the N numbers in random order.
*/

import edu.princeton.cs.algs4.StdRandom;

public class Algs_1_1_34_Filtering
{
    public static void main(String[] args)
    {
        double[] input = new double[500];
        for (int i = 0; i < 500; i++)
            input[i] = StdRandom.uniform();

        // Print the maximum and minimum numbers.
        printMinMax(input);

        // Print the median of the numbers.
        // save all values

        // Print the k th smallest value, for k less than 100.
        double[] smallestValues = new double[100];

        // Print the sum of the squares of the numbers.
        printSumOfSquares(input);

        // Print the average of the N numbers.
        printAverage(input);

        // Print the percentage of numbers greater than the average.
        // save all values

        // Print the N numbers in increasing order.
        // save all values

        // Print the N numbers in random order.
        // save all values
    }

    private static void printAverage(double[] input)
    {
        int n = 0;
        double sum = 0;
        for (double number : input)
        {
            n++;
            sum += number;
        }
        System.out.println("Average: " + sum / n);
    }

    private static void printSumOfSquares(double[] input)
    {
        double sumOfSquares = 0;
        for (double number : input)
            sumOfSquares += (number * number);
        System.out.println("sum of squares: " + sumOfSquares);
    }

    private static void printMinMax(double[] input)
    {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (double number : input)
        {
            if (number < min)
                min = number;
            if (number > max)
                max = number;
        }
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }
}
