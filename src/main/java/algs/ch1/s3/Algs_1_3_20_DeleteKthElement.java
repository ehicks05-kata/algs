package algs.ch1.s3;

/*
    1.3.20  Write a method  delete() that takes an  int argument  k and deletes the  k th ele-
    ment in a linked list, if it exists.
    
* */

public class Algs_1_3_20_DeleteKthElement
{
    public static void main(String[] args) throws Exception
    {
        Node first = new Node("1");
        Node second = new Node("2");
        Node third = new Node("3");
        Node fourth = new Node("4");

        first.next = second;
        second.next = third;
        third.next = fourth;

        System.out.println(first);
        delete(first, 2);
        System.out.println(first);
        delete(first, 4);
        System.out.println(first);
    }

    public static void delete(Node first, int k)
    {
        if (first.next == null || k < 2)
            return;

        int i = 1;
        Node previous = null;
        Node current = first;
        while (current.next != null && i < k)
        {
            previous = current;
            current = current.next;
            i++;
        }
        previous.next = current.next;
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
