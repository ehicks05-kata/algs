package algs.ch1.s3;

/*
    1.3.17  Do Exercise 1.3.16 for  Transaction
    
* */

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Algs_1_3_17_ReadTransactionStrings
{
    public static void main(String[] args) throws Exception
    {
        String transactions = "";
        for (int i = 0; i < 10; i++)
        {
            String name = "anon";
            int month = StdRandom.uniform(11) + 1;
            int day = StdRandom.uniform(30) + 1;
            int year = StdRandom.uniform(120) + 1900;
            String date = month + "/" + day + "/" + year;
            double amount = StdRandom.uniform(0, 2000);
            transactions += name + " " + date + " " + amount + ",";
        }

        String[] datesArray = readTransactions(transactions);
        System.out.println(Arrays.toString(datesArray));
    }

    public static String[] readTransactions(String input)
    {
        Queue<String> transactionQueue = new Queue<>();
        for (String date : input.split(","))
            transactionQueue.enqueue(date);
        String[] transactionsArray = new String[transactionQueue.size()];

        int i = 0;
        for (String date : transactionQueue)
            transactionsArray[i++] = date;
        return transactionsArray;
    }
}
