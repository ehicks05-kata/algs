package algs.ch1.s3;

/*
    1.3.33 Deque. A double-ended queue or deque (pronounced “deck”) is like a stack or
    a queue but supports adding and removing items at both ends. A deque stores a collec-
    tion of items and supports the following API:
    public class Deque<Item> implements Iterable<Item>
    Deque()  create an empty deque
    boolean isEmpty()  is the deque empty?
    int size()  number of items in the deque
    void pushLeft(Item item)  add an item to the left end
    void pushRight(Item item)  add an item to the right end
    Item popLeft()  remove an item from the left end
    Item popRight()  remove an item from the right end
    API for a generic double-ended queue
    Write a class Deque that uses a doubly-linked list to implement this API and a class
    ResizingArrayDeque that uses a resizing array.
* */

import java.util.Iterator;

public class Algs_1_3_33_Deque
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("Linked List Deque Demo");
        Deque<Integer> deque = new Deque<>();
        System.out.println("isEmpty? " + deque.isEmpty());
        System.out.println("size " + deque.size());
        deque.pushRight(0);
        System.out.println("isEmpty? " + deque.isEmpty());
        System.out.println("size " + deque.size());
        deque.pushLeft(1);
        deque.pushLeft(2);
        deque.pushLeft(3);
        System.out.println(deque.popLeft());
        System.out.println(deque.popRight());
        deque.pushRight(4);
        System.out.println(deque.popLeft());
        System.out.println(deque.popRight());
        System.out.println(deque.popLeft());
        System.out.println("isEmpty? " + deque.isEmpty());
        System.out.println("size " + deque.size());

        System.out.println("\n\nResizingArrayDeque Demo");
        ResizingArrayDeque<Integer> deque2 = new ResizingArrayDeque<>();
        System.out.println("isEmpty? " + deque2.isEmpty());
        System.out.println("size " + deque2.size());
        deque2.pushRight(0);
        System.out.println("isEmpty? " + deque2.isEmpty());
        System.out.println("size " + deque2.size());
        deque2.pushLeft(1);
        deque2.pushLeft(2);
        deque2.pushLeft(3);
        System.out.println(deque2.popLeft());
        System.out.println(deque2.popRight());
        deque2.pushRight(4);
        System.out.println(deque2.popLeft());
        System.out.println(deque2.popRight());
        System.out.println(deque2.popLeft());
        System.out.println("isEmpty? " + deque2.isEmpty());
        System.out.println("size " + deque2.size());
    }

    public static class Deque<Item> implements Iterable<Item>
    {
        DoubleNode<Item> first;
        DoubleNode<Item> last;

        @Override
        public String toString()
        {
            if (first == null)
                return "";

            StringBuilder sb = new StringBuilder();
            DoubleNode<Item> node = first;
            while (node != null)
            {
                sb.append(" ").append(node.data);
                node = node.next;
            }
            return sb.toString();
        }

        boolean isEmpty()
        {
            return first == null;
        }

        int size()
        {
            if (first == null) return 0;
            int size = 0;
            DoubleNode<Item> current = first;
            while (current != null)
            {
                size++;
                current = current.next;
            }
            return size;
        }
        void pushLeft(Item item)
        {
            DoubleNode<Item> node = new DoubleNode<>(item);
            if (first == null)
            {
                first = node;
                last = node;
                return;
            }

            node.next = first;
            first.prev = node;
            first = node;
        }
        void pushRight(Item item)
        {
            DoubleNode<Item> node = new DoubleNode<>(item);
            if (first == null)
            {
                first = node;
                last = node;
                return;
            }

            node.prev = last;
            last.next = node;
            last = node;
        }
        Item popLeft()
        {
            if (first == null)
                return null;

            DoubleNode<Item> oldFirst = first;
            DoubleNode<Item> newFirst = first.next;
            if (newFirst != null)
                newFirst.prev = null;
            first.next = null;
            first = newFirst;

            return oldFirst.data;
        }
        Item popRight()
        {
            if (last == null)
                return null;

            DoubleNode<Item> oldLast = last;
            DoubleNode<Item> newLast = last.prev;
            if (newLast != null)
                newLast.next = null;
            last.prev = null;
            last = newLast;

            return oldLast.data;
        }

        @Override
        public Iterator<Item> iterator()
        {
            return null;
        }
    }

    public static class ResizingArrayDeque<Item> implements Iterable<Item>
    {
        Item[] items = (Item[]) new Object[1];
        int size = 0;
        int start = 0;
        int end = 0;

        @Override
        public String toString()
        {
            if (size == 0)
                return "";

            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < size)
                sb.append(" ").append(items[start + i++]); // todo deal with wrapping
            return sb.toString();
        }

        boolean isEmpty()
        {
            return size == 0;
        }
        int size()
        {
            return size;
        }
        void pushLeft(Item item)
        {
            if (size == 0)
                items[0] = item;
            else
            {
                int index = start - 1;
                if (index < 0)
                    index = items.length - 1;
                items[index] = item;

                start = index;
            }

            size++;
            if (size == items.length)
                embiggen();
        }
        void pushRight(Item item)
        {
            if (size == 0)
                items[0] = item;
            else
            {
                int index = end + 1;
                if (index > items.length - 1)
                    index = 0;
                items[index] = item;

                end = index;
            }

            size++;
            if (size == items.length)
                embiggen();
        }
        Item popLeft()
        {
            Item item = items[start];

            start++;
            if (start > items.length - 1)
                start = 0;

            size--;
            if (size == items.length / 4)
                shrink();

            return item;
        }
        Item popRight()
        {
            Item item = items[end];

            end--;
            if (end < 0)
                end = items.length - 1;

            size--;
            if (size == items.length / 4)
                shrink();

            return item;
        }

        private void shrink()
        {
            int newSize = items.length / 2;
            Item[] newItems = (Item[]) new Object[newSize];
            int oldStart = start;
            for (int i = 0; i < items.length; i++)
            {
                if (i < oldStart)
                    newItems[i] = items[i];
                else
                    newItems[i] = items[i - items.length];
            }
            start -= items.length;
            items = newItems;
        }

        private void embiggen()
        {
            int newSize = items.length * 2;
            Item[] newItems = (Item[]) new Object[newSize];
            int oldStart = start;
            for (int i = 0; i < items.length; i++)
            {
                if (i < oldStart || i == end)
                    newItems[i] = items[i];
                else
                    newItems[i] = items[i + items.length];
            }
            start += items.length;
            items = newItems;
        }

        @Override
        public Iterator<Item> iterator()
        {
            return null;
        }
    }

    public static class DoubleNode<Item>
    {
        Item data;
        DoubleNode<Item> prev;
        DoubleNode<Item> next;

        DoubleNode(Item data) {
            this.data = data;
        }

        @Override
        public String toString()
        {
            return "DoubleNode{" +
                    "data=" + data +
                    '}';
        }
    }
}
