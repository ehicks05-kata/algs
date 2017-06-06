package algs.ch1.s3;

/*
    1.3.23  Why does the following code fragment not do the same thing as in the previous
    question?
    x.next = t;
    t.next = x.next;
    Answer : When it comes time to update  t.next ,  x.next is no longer the original node
    following  x , but is instead  t itself!
    
* */

public class Algs_1_3_23_LinkedListFragment
{
    public static void main(String[] args) throws Exception
    {

    }
}