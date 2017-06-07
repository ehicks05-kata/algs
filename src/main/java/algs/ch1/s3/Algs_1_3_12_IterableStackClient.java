package algs.ch1.s3;

/*
    1.3.12  Write an iterable  Stack client that has a static method  copy() that takes a stack
    of strings as argument and returns a copy of the stack. Note : This ability is a prime
    example of the value of having an iterator, because it allows development of such func-
    tionality without changing the basic API.
    
* */


import edu.princeton.cs.algs4.Stack;

public class Algs_1_3_12_IterableStackClient
{
    public static void main(String[] args) throws Exception
    {
        Stack<String> numbers = new Stack<>();
        numbers.push("1");
        numbers.push("2");
        numbers.push("3");

        System.out.println("original:");
        for (String item : numbers)
            System.out.println(item);

        Stack<String> copy = copy(numbers);
        System.out.println("copy:");
        for (String item : copy)
            System.out.println(item);
    }

    private static Stack<String> copy(Stack<String> input)
    {
        Stack<String> copy = new Stack<>();
        for (String item : input)
            copy.push(item);
        Stack<String> copy2 = new Stack<>();
        for (String item : copy)
            copy2.push(item);
        return copy2;
    }
}
