package algs.ch1.s3;

/*
    1.3.50 Fail-fast iterator. Modify the iterator code in  Stack to immediately throw a
    java.util.ConcurrentModificationException if the client modifies the collection
    (via  push() or  pop() ) during iteration? b).
    Solution: Maintain a counter that counts the number of  push() and  pop() operations.
    When creating an iterator, store this value as an  Iterator instance variable. Before
    each call to  hasNext() and  next() , check that this value has not changed since con-
    struction of the iterator; if it has, throw the exception.
* */

public class Algs_1_3_50_FailFastIterator
{
    public static void main(String[] args) throws Exception
    {

    }
}
