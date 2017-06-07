package algs.ch1.s3;

/*
    1.3.14  Develop a class  ResizingArrayQueueOfStrings that implements the queue
    abstraction with a fixed-size array, and then extend your implementation to use array
    resizing to remove the size restriction.
* */

import java.util.Arrays;

public class Algs_1_3_14_ResizingArrayQueueOfStrings
{
    public static void main(String[] args) throws Exception
    {
        Queue queue = new Queue(5);
        System.out.println(queue);

        for (int i = 0; i < 6; i++)
        {
            try
            {
                queue.enqueue(String.valueOf(i));
                System.out.println(queue);
            }
            catch (Exception e)
            {
                System.out.println("array index out of bounds. i=" + i);
                System.out.println(queue);
            }
        }

        ResizingQueue resizingQueue = new ResizingQueue();
        System.out.println("\r\n"+resizingQueue);
        for (int i = 0; i < 16; i++)
        {
            resizingQueue.enqueue(String.valueOf(i));
            System.out.println(resizingQueue);
        }
        for (int i = 0; i < 16; i++)
        {
            resizingQueue.dequeue();
            System.out.println(resizingQueue);
        }
    }

    private static class Queue
    {
        private String[] array;
        private int size;

        public Queue(int capacity)
        {
            array = new String[capacity];
        }

        public void enqueue(String item)
        {
            array[size++] = item;
        }

        public String dequeue()
        {
            return array[--size];
        }

        @Override
        public String toString()
        {
            return "Queue{" +
                    "array=" + Arrays.toString(array) +
                    ", size=" + size +
                    '}';
        }
    }

    private static class ResizingQueue
    {
        private String[] array;
        private int size;

        public ResizingQueue()
        {
            array = new String[2];
        }

        public void resize(int newSize)
        {
            String[] resized = new String[newSize];
            for (int i = 0; i < size; i++)
                resized[i] = array[i];

            array = resized;
        }

        public void enqueue(String item)
        {
            if (size == array.length)
                resize(array.length * 2);

            array[size++] = item;
        }

        public String dequeue()
        {
            String item = array[--size];
            if (size == array.length / 4)
                resize(array.length / 2);
            return item;
        }

        @Override
        public String toString()
        {
            return "ResizingQueue{" +
                    "array=" + Arrays.toString(array) +
                    ", size=" + size +
                    ", length=" + array.length +
                    '}';
        }
    }
}
