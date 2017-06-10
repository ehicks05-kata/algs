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

        List list = new List(first);
        list.insertEnd(second);
        list.insertEnd(third);
        list.insertEnd(fourth);


    }

    public static class List
    {
        DoubleNode first;

        static void insertBeginning(DoubleNode node)
        {

        }

        static void insertEnd(DoubleNode node)
        {

        }

        static DoubleNode removeBeginning()
        {

        }

        static DoubleNode removeEnd()
        {

        }

        static void insertBeforeGiven(DoubleNode newNode, DoubleNode given)
        {

        }

        static void insertAfterGiven(DoubleNode newNode, DoubleNode given)
        {

        }

        static DoubleNode removeGiven(DoubleNode given)
        {

        }

        public List(DoubleNode first) {
            this.first = first;
        }
    }

    public static class DoubleNode
    {
        int id;
        DoubleNode prev;
        DoubleNode next;

        public DoubleNode(int id) {
            this.id = id;
        }
    }
}
