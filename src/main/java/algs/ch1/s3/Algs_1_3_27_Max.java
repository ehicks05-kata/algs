package algs.ch1.s3;

/*
    1.3.27  Write a method  max() that takes a reference to the first node in a linked list as
    argument and returns the value of the maximum key in the list. Assume that all keys are
    positive integers, and return  0 if the list is empty.
* */

public class Algs_1_3_27_Max
{
    public static void main(String[] args) throws Exception
    {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(8);
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
        while (node != null)
        {
            if (node.data > max)
                max = node.data;

            node = node.next;
        }

        return max;
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
