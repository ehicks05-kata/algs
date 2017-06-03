package algs;

/*
    1.2.10  Develop a class  VisualCounter that allows both increment and decrement
    operations. Take two arguments  N and  max in the constructor, where  N specifies the
    maximum number of operations and  max specifies the maximum absolute value for
    the counter. As a side effect, create a plot showing the value of the counter each time its
    tally changes.
* */

import edu.princeton.cs.algs4.StdRandom;

public class Algs_1_2_10_VisualCounter
{
    public static void main(String[] args)
    {
        VisualCounter visualCounter = new VisualCounter(2000, 20);
        int n = StdRandom.uniform(2000);
        for (int i = 0; i < n; i++)
        {
            if (StdRandom.bernoulli())
                visualCounter.inc();
            else
                visualCounter.dec();
        }
    }

    private static class VisualCounter
    {
        int count = 0;
        int operations = 0;
        int n;
        int max;

        public VisualCounter(int n, int max)
        {
            this.n = n;
            this.max = max;
        }

        public void inc()
        {
            updateCount(1);
        }

        public void dec()
        {
            updateCount(-1);
        }

        private void updateCount(int change)
        {
            if (operations < n)
            {
                operations++;
                if (count < max || change < 0)
                {
                    count += change;
                    System.out.println(count);
                }
                else
                    System.out.println("count cannot exceed max");
            }
            else
                System.out.println("max ops reached");
        }
    }
}
