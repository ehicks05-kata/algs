package algs.ch1.s3;

/*
    1.3.16  Using  readInts() on page 126 as a model, write a static method  readDates() for
    Date that reads dates from standard input in the format specified in the table on page 119
    and returns an array containing them.

    public static int[] readInts(String name)
    {
        In in = new In(name);
        Queue<Integer> q = new Queue<Integer>();
        while (!in.isEmpty())
            q.enqueue(in.readInt());
        int N = q.size();
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = q.dequeue();
        return a;

        date format: 5/22/1939
    }
* */

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Algs_1_3_16_ReadDateStrings
{
    public static void main(String[] args) throws Exception
    {
        String dates = "";
        for (int i = 0; i < 10; i++)
        {
            int month = StdRandom.uniform(11) + 1;
            int day = StdRandom.uniform(30) + 1;
            int year = StdRandom.uniform(120) + 1900;
            dates += month + "/" + day + "/" + year + " ";
        }

        String[] datesArray = readDates(dates);
        System.out.println(Arrays.toString(datesArray));
    }

    public static String[] readDates(String input)
    {
        Queue<String> datesQueue = new Queue<>();
        for (String date : input.split(" "))
            datesQueue.enqueue(date);
        String[] datesArray = new String[datesQueue.size()];

        int i = 0;
        for (String date : datesQueue)
            datesArray[i++] = date;
        return datesArray;
    }
}
