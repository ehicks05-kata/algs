package algs.ch1.s3;

/*
    1.3.7  Add a method  peek() to  Stack that returns the most recently inserted item on
    the stack (without popping it).
    
* */

public class Algs_1_3_07_StackPeek
{
    public static void main(String[] args) throws Exception
    {
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(5);
        s.push("1");
        System.out.println(s.peek());
        s.push("2");
        System.out.println(s.peek());
        s.push("3");
        System.out.println(s.peek());
        s.pop();
        System.out.println(s.peek());
    }

    public static class FixedCapacityStackOfStrings
    {
        private String[] a; // stack entries
        private int N; // size

        public FixedCapacityStackOfStrings(int cap)
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

        public String peek()
        {
            return a[N - 1];
        }
    }
}
