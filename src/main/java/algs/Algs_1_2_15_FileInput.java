package algs;

/*
    1.2.15 File input. Develop a possible implementation of the static readInts() meth-
    od from  In (which we use for various test clients, such as binary search on page 47) that
    is based on the  split() method in  String .

    Solution:
    public static int[] readInts(String name)
    {
        In in = new In(name);
        String input = StdIn.readAll();
        String[] words = input.split("\\s+");
        int[] ints = new int[words.length;
        for int i = 0; i < word.length; i++)
            ints[i] = Integer.parseInt(words[i]);
        return ints;
    }

    We will consider a different implementation in Section 1.3 (see page 126).
* */

import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class Algs_1_2_15_FileInput
{
    public static void main(String[] args) throws Exception
    {
        String filename = "input.txt";
        System.out.println(Arrays.toString(readInts(filename)));
    }

    public static int[] readInts(String name)
    {
        In in = new In(name);
        String all = in.readAll();
        String[] allTokens = all.split(" ");
        int[] allInts = new int[allTokens.length];
        for (int i = 0; i < allTokens.length; i++)
            allInts[i] = Integer.parseInt(allTokens[i]);
        return allInts;
    }
}
