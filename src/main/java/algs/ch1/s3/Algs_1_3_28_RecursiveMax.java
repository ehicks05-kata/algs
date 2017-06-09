package algs.ch1.s3;

/*
    1.3.28  Develop a recursive solution to the previous question.
* */

public class Algs_1_3_28_RecursiveMax
{
    public static void main(String[] args) throws Exception
    {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(7);
        Node fourth = new Node(4);
        Node fifth = new Node(3);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        System.out.println(max(first));
    }

    public static Integer max(Node node)
    {
        Integer max = 0;
        return _max(node, max);
    }

    public static Integer _max(Node node, Integer max)
    {
        if (node == null)
            return max;

        if (node.data > max)
            max = node.data;

        return _max(node.next, max);
    }

    public static class Node
    {
        Integer data;
        Node next;

        public Node(Integer data)
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
