package algs.ch1.s3;

/*
    1.3.15  Write a  Queue client that takes a command-line argument  k and prints the  k th
    from the last string found on standard input (assuming that standard input has  k or
    more strings).
* */

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdRandom;

public class Algs_1_3_15_QueueClient
{
    public static void main(String[] args) throws Exception
    {
        int k = StdRandom.uniform(10);
        System.out.println("k=" + k);
        String input = "";
        for (int i = 0; i < 10; i++)
            input += " " + i;

        Queue<String> queue = new Queue<>();
        for (String item : input.split(" "))
            queue.enqueue(item);

        System.out.println(queue);

        Stack<String> stack = new Stack<>();
        for (String item : queue)
            stack.push(item);

        queue = new Queue<>();
        for (String item : stack)
            queue.enqueue(item);

        for (int i = 0; i < k; i++)
            queue.dequeue();

        System.out.println(queue.dequeue());
    }
}
