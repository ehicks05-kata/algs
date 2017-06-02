package algs;

/*
    1.1.26 Sorting three numbers.

    Suppose that the variables  a ,  b ,  c , and  t are all of the
    same numeric primitive type. Show that the following code puts  a ,  b , and  c in ascending
    order:
    if (a > b) { t = a; a = b; b = t; }
    if (a > c) { t = a; a = c; c = t; }
    if (b > c) { t = b; b = c; c = t; }
* */

public class Algs_1_1_26_SortingThreeNumbers
{
    /*
    *
    321
	swap a b
	231
	swap a c
	132
	swap b c
	123

	after first block, a <= b
	after second block, a <= b && a <= c
	after third block, in addition to the last step, b is now <= case
    * */
}
