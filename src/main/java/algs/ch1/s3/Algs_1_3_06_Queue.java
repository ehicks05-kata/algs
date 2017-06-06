package algs.ch1.s3;

/*
    1.3.6  What does the following code fragment do to the queue  q ?
    Stack<String> stack = new Stack<String>();
    while (!q.isEmpty())
        stack.push(q.dequeue());
    while (!stack.isEmpty())
        q.enqueue(stack.pop());


    reverses the queue
* */

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class Algs_1_3_06_Queue
{
    public static void main(String[] args) throws Exception
    {
        Queue<String> numbers = new Queue<>();
        numbers.enqueue("1");
        numbers.enqueue("2");
        numbers.enqueue("3");
        numbers.enqueue("4");

        mystery(numbers);
    }

    public static void mystery(Queue<String> q)
    {
        Stack<String> stack = new Stack<>();
        while (!q.isEmpty())
            stack.push(q.dequeue());
        while (!stack.isEmpty())
            q.enqueue(stack.pop());

        System.out.println(q);
    }
}
