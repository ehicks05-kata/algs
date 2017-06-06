package algs.ch1.s3;

/*
    1.3.46  Forbidden triple for stack generability. Prove that a permutation can be gener-
    ated by a stack (as in the previous question) if and only if it has no forbidden triple (a, b,
    c) such that a < b < c with c first, a second, and b third (possibly with other intervening
    integers between c and a and between a and b).
    Partial solution: Suppose that there is a forbidden triple (a, b, c). Item c is popped before
    a and b, but a and b are pushed before c. Thus, when c is pushed, both a and b are on
    the stack. Therefore, a cannot be popped before b.
* */

public class Algs_1_3_46_ForbiddenTriple
{
    public static void main(String[] args) throws Exception
    {

    }
}
