package algs.ch1.s3;

/*
    1.3.29  Write a  Queue implementation that uses a circular linked list, which is the same
    as a linked list except that no links are null and the value of  last.next is  first when-
    ever the list is not empty. Keep only one  Node instance variable ( last ).
* */

public class Algs_1_3_29_CircularQueue
{
    public static void main(String[] args) throws Exception
    {
        Algs_1_3_29_CircularQueue queue = new Algs_1_3_29_CircularQueue();
        queue.enqueue(new Node("1"));
        queue.enqueue(new Node("2"));
        queue.enqueue(new Node("7"));
        queue.enqueue(new Node("4"));
        queue.enqueue(new Node("3"));
        System.out.println(queue);
    }

    Node last;

    public Algs_1_3_29_CircularQueue()
    {
        this.last = null;
    }

    // node will become last
    // figure out first
    public void enqueue(Node node)
    {
        if (last == null)
        {
            last = node;
            last.next = last;
            return;
        }

        Node first = last.next;
        node.next = first;
        Node formerLast = last;
        formerLast.next = node;
        last = node;
    }

    public Node dequeue()
    {
        return last.next;
    }

    public String toString()
    {
        String output = "";
        Node node = last.next;
        while (node != null)
        {
            output += node.data + " ";
            node = node.next;

            if (node == last.next)
                break;
        }
        return output;
    }

    public static class Node
    {
        String data;
        Node next;

        public Node(String data)
        {
            this.data = data;
        }

        @Override
        public String toString()
        {
            return "Node{" +
                    "data='" + data + '\'' +
                    '}';
        }
    }
}
