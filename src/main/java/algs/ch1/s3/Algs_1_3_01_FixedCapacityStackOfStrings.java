package algs.ch1.s3;

/*
    1.3.1  Add a method  isFull() to  FixedCapacityStackOfStrings.
* */

public class Algs_1_3_01_FixedCapacityStackOfStrings
{
    private String[] a; // stack entries
    private int N; // size

    public Algs_1_3_01_FixedCapacityStackOfStrings(int cap)
    {
        a = new String[cap];
    }

    public boolean isEmpty()
    {
        return N == 0;
    }

    public int size()
    {
        return N;
    }

    public void push(String item)
    {
        a[N++] = item;
    }

    public String pop()
    {
        return a[--N];
    }

    public boolean isFull()
    {
        return N == a.length;
    }

    public static void main(String[] args) throws Exception
    {
        Algs_1_3_01_FixedCapacityStackOfStrings stack = new Algs_1_3_01_FixedCapacityStackOfStrings(4);
        System.out.println(stack.isFull());
        stack.push("peace");
        System.out.println(stack.isFull());
        stack.push("through");
        System.out.println(stack.isFull());
        stack.push("power");
        System.out.println(stack.isFull());
        stack.push(".");
        System.out.println(stack.isFull());
        stack.push("..."); // blows up here
    }
}
