package algs.ch1.s3;

/*
    1.3.30  Write a function that takes the first  Node in a linked list as argument and (de-
    structively) reverses the list, returning the first  Node in the result.

    Iterative solution : To accomplish this task, we maintain references to three consecutive
    nodes in the linked list,  reverse ,  first , and  second . At each iteration, we extract the
    node  first from the original linked list and insert it at the beginning of the reversed
    list. We maintain the invariant that  first is the first node of what’s left of the original
    list,  second is the second node of what’s left of the original list, and  reverse is the first
    node of the resulting reversed list.
    public Node reverse(Node x)
    {
        Node first = x;
        Node reverse = null;
        while (first != null)
        {
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        return reverse;
    }
    When writing code involving linked lists, we must always be careful to properly handle
    the exceptional cases (when the linked list is empty, when the list has only one or two
    nodes) and the boundary cases (dealing with the first or last items). This is usually
    much trickier than handling the normal cases.
    Recursive solution : Assuming the linked list has N nodes, we recursively reverse the last
    N – 1 nodes, and then carefully append the first node to the end.
    public Node reverse(Node first)
    {
        if (first == null) return null;
        if (first.next == null) return first;
        Node second = first.next;
        Node rest = reverse(second);
        second.next = first;
        first.next = null;
        return rest;
    }
* */

public class Algs_1_3_30_ReverseList
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

        System.out.println(reverse(first));
    }

    public static Node reverse(Node node)
    {
        Node newFirst = null;

        return newFirst;
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
