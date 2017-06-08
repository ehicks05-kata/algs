package algs.ch1.s3;

/*
    1.3.25  Write a method  insertAfter() that takes two linked-list  Node arguments and
    inserts the second after the first on its list (and does nothing if either argument is null).
* */

public class Algs_1_3_25_InsertAfter
{
    public static void main(String[] args) throws Exception
    {
        Node first = new Node("1");
        Node second = new Node("2");
        Node third = new Node("3");
        Node fourth = new Node("4");

        first.next = second;
//        second.next = third;
//        third.next = fourth;

        insertAfter(second, third);
        System.out.println(first);
        insertAfter(third,  fourth);
        System.out.println(first);
    }

    public static void insertAfter(Node node1, Node node2)
    {
        if (node1 == null || node2 == null)
            return;
        node2.next = node1.next;
        node1.next = node2;
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
