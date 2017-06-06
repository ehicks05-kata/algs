package algs.ch1.s3;

/*
    1.3.2  Give the output printed by  java Stack for the input
    it was - the best - of times - - - it was - the - -

    was
    best
    times
    of
    the
    was
    the
    it
* */

import edu.princeton.cs.algs4.Stack;

public class Algs_1_3_02_StackOutput
{
    public static void main(String[] args) throws Exception
    {
        Stack<String> words = new Stack<>();
        String[] input = new String[]{"it", "was", "-", "the", "best", "-", "of",
                "times", "-", "-", "-", "it", "was", "-", "the", "-", "-"};

        for (String word : input)
        {
            if (word.equals("-"))
                System.out.println(words.pop());
            else
                words.push(word);
        }
    }
}
