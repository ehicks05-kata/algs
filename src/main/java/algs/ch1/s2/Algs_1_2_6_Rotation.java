package algs.ch1.s2;

/*
    1.2.6  A string  s is a circular rotation of a string  t if it matches when the characters
    are circularly shifted by any number of positions; e.g.,  ACTGACG is a circular shift of
    TGACGAC , and vice versa. Detecting this condition is important in the study of genomic
    sequences. Write a program that checks whether two given strings  s and  t are circular
    shifts of one another. Hint : The solution is a one-liner with  indexOf() ,  length() , and
    string concatenation.
* */

public class Algs_1_2_6_Rotation
{
    public static void main(String[] args)
    {
        String s = "ACTGACG";
        String t = "TGACGAC";

        System.out.println(isCircularRotation(s, t));
    }

    /*
    *  I cheated and stack-overflowed this. The trick is doubling up one of the strings.
    *  Every possible rotation should be contained in the doubled string.
    * */
    public static boolean isCircularRotation(String s1, String s2)
    {
        return s1.length() == s2.length() && (s1 + s1).indexOf(s2) > 0;
    }
}
