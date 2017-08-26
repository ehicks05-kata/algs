package algs.ch1.s3;

/*
    1.3.32 Steque. A stack-ended queue or steque is a data type that supports push, pop, and
    enqueue. Articulate an API for this ADT. Develop a linked-list-based implementation.
* */

public class Algs_1_3_32_Steque
{
    public static void main(String[] args) throws Exception
    {
        Steque steque = new Steque();

        steque.enqueue(new Node(0));
        steque.push(new Node(1));
        steque.push(new Node(2));
        steque.push(new Node(3));
        System.out.println(steque);

        steque.pop();
        System.out.println(steque);

        steque.enqueue(new Node(4));
        System.out.println(steque);
    }

    public static class Steque
    {
        Node first;

        @Override
        public String toString()
        {
            return "" + first;
        }

        public void push(Node node)
        {
            if (first == null)
            {
                first = node;
                return;
            }

            node.next = first;
            first = node;
        }

        public Node pop()
        {
            Node node = first;
            first = first.next;
            return node;
        }

        public void enqueue(Node node)
        {
            if (first == null)
            {
                first = node;
                return;
            }

            Node current = first;
            while (current.next != null)
                current = current.next;
            current.next = node;
        }
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
