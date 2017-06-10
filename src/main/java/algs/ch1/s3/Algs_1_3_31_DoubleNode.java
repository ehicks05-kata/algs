package algs.ch1.s3;

/*
    1.3.31  Implement a nested class  DoubleNode for building doubly-linked lists, where
    each node contains a reference to the item preceding it and the item following it in the
    list ( null if there is no such item). Then implement static methods for the following
    tasks: insert at the beginning, insert at the end, remove from the beginning, remove
    from the end, insert before a given node, insert after a given node, and remove a given
    node.
* */

public class Algs_1_3_31_DoubleNode
{
    public static void main(String[] args) throws Exception
    {
        DoubleNode first = new DoubleNode(2);
        DoubleNode second = new DoubleNode(0);
        DoubleNode third = new DoubleNode(9);
        DoubleNode fourth = new DoubleNode(7);
        DoubleNode zeroth = new DoubleNode(5);
        DoubleNode fifth = new DoubleNode(6);
        DoubleNode sixth = new DoubleNode(4);

        DoubleNode.insertEnd(first, second);
        DoubleNode.insertEnd(first, third);
        DoubleNode.insertEnd(first, fourth);
        DoubleNode.insertBeginning(first, zeroth);
        DoubleNode.removeBeginning(first);
        DoubleNode.removeEnd(first);
        DoubleNode.insertBeforeGiven(first, third, fifth);
        DoubleNode.insertAfterGiven(first, third, sixth);
        DoubleNode.removeGiven(first, third);

        System.out.println(first);
    }

    public static class DoubleNode
    {
        int id;
        DoubleNode prev;
        DoubleNode next;

        public DoubleNode(int id) {
            this.id = id;
        }

        @Override
        public String toString()
        {
            String string = "";
            DoubleNode node = this;
            while (true)
            {
                if (node.prev == null)
                    break;
                node = node.prev;
            }
            while (node != null)
            {
                string += node.id + " ";
                node = node.next;
            }
            return string;
        }

        static void insertBeginning(DoubleNode existing, DoubleNode newNode)
        {
            DoubleNode node = existing;
            while (node.prev != null)
                node = node.prev;
            node.prev = newNode;
            newNode.next = node;
        }

        static void insertEnd(DoubleNode existing, DoubleNode newNode)
        {
            DoubleNode node = existing;
            while (node.next != null)
                node = node.next;
            node.next = newNode;
            newNode.prev = node;
        }

        static DoubleNode removeBeginning(DoubleNode existing)
        {
            DoubleNode node = existing;
            while (true)
            {
                if (node.prev == null)
                    break;
                node = node.prev;
            }
            if (node.next != null)
                node.next.prev = null;
            node.next = null;
            return node;
        }

        static DoubleNode removeEnd(DoubleNode existing)
        {
            DoubleNode node = existing;
            while (true)
            {
                if (node.next == null)
                    break;
                node = node.next;
            }
            if (node.prev != null)
                node.prev.next = null;
            node.prev = null;
            return node;
        }

        static void insertBeforeGiven(DoubleNode existing, DoubleNode given, DoubleNode newNode)
        {
            DoubleNode node = existing;
            while (true)
            {
                if (node.prev == null)
                    break;
                node = node.prev;
            }
            while (node != null)
            {
                if (node.id == given.id)
                {
                    DoubleNode prev = node.prev;
                    if (prev != null)
                    {
                        prev.next = newNode;
                        newNode.prev = prev;
                    }
                    node.prev = newNode;
                    newNode.next = node;
                }
                node = node.next;
            }
        }

        static void insertAfterGiven(DoubleNode existing, DoubleNode given, DoubleNode newNode)
        {
            DoubleNode node = existing;
            while (true)
            {
                if (node.prev == null)
                    break;
                node = node.prev;
            }
            while (node != null)
            {
                if (node.id == given.id)
                {
                    DoubleNode next = node.next;
                    if (next != null)
                    {
                        next.prev = newNode;
                        newNode.next = next;
                    }
                    node.next = newNode;
                    newNode.prev = node;
                }
                node = node.next;
            }
        }

        static DoubleNode removeGiven(DoubleNode existing, DoubleNode given)
        {
            DoubleNode node = existing;
            while (true)
            {
                if (node.prev == null)
                    break;
                node = node.prev;
            }
            while (node != null)
            {
                if (node.id == given.id)
                {
                    DoubleNode prev = node.prev;
                    DoubleNode next = node.next;
                    if (prev != null)
                        prev.next = next;
                    if (next != null)
                        next.prev = prev;
                    node.prev = null;
                    node.next = null;
                    return node;
                }
                node = node.next;
            }
            return null;
        }
    }
}
