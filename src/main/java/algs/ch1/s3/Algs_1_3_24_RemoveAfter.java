package algs.ch1.s3;

/*
    1.3.24  Write a method  removeAfter() that takes a linked-list  Node as argument and
    removes the node following the given one (and does nothing if the argument or the next
    field in the argument node is null).
* */

public class Algs_1_3_24_RemoveAfter
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

        removeAfter(first);
        System.out.println(first);
        removeAfter(third);
        System.out.println(first);
    }

    public static void removeAfter(Node node)
    {
        Node child = node.next;
        node.next = child.next;
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
