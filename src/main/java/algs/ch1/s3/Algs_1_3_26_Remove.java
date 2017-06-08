package algs.ch1.s3;

/*
    1.3.26  Write a method  remove() that takes a linked list and a string  key as arguments
    and removes all of the nodes in the list that have  key as its item field.
* */

public class Algs_1_3_26_Remove
{
    public static void main(String[] args) throws Exception
    {
        Node first = new Node("1");
        Node second = new Node("2");
        Node third = new Node("3");
        Node fourth = new Node("4");
        Node fifth = new Node("3");

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        remove(first, "2");
        System.out.println(first);
        remove(first, "3");
        System.out.println(first);
    }

    public static void remove(Node node, String data)
    {
        Node previous = node;
        node = node.next;
        while (node != null)
        {
            if (node.data.equals(data))
            {
                previous.next = node.next;
            }
            previous = node.next;
            if (node.next != null)
                node = node.next.next;
            else
                node = null;
        }
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
            String list = "";
            Node node = this;
            while (node != null)
            {
                list += node.data + " ";
                node = node.next;
            }
            return list;
        }
    }
}
