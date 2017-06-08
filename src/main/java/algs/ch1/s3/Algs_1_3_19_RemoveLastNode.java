package algs.ch1.s3;

/*
    1.3.19  Give a code fragment that removes the last node in a linked list whose first node
    is  first
    
* */

public class Algs_1_3_19_RemoveLastNode
{
    public static void main(String[] args) throws Exception
    {
        Node first = new Node("1");
        Node second = new Node("2");
        Node third = new Node("3");

        first.next = second;
        second.next = third;

        System.out.println(first);
        removeLast(first);
        System.out.println(first);
    }

    public static void removeLast(Node first)
    {
        if (first.next == null)
            return;
        
        Node previous = null;
        Node current = first;
        while (current.next != null)
        {
            previous = current;
            current = current.next;
        }
        previous.next = null;
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
