package algs.ch1.s3;

/*
    1.3.21  Write a method  find() that takes a linked list and a string  key as arguments
    and returns  true if some node in the list has  key as its item field,  false otherwise.
    
* */

public class Algs_1_3_21_FindInLinkedList
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

        System.out.println(find(first, "5"));
        System.out.println(find(first, "4"));
        System.out.println(find(first, "3"));
    }

    public static boolean find(Node first, String data)
    {
        Node current = first;
        while (current != null)
        {
            if (current.data.equals(data))
                return true;
            current = current.next;
        }
        return false;
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
