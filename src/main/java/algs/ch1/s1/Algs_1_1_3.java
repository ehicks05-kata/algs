package algs.ch1.s1;

/*
    1.1.3

    Write a program that takes three integer command-line arguments and prints
    equal if all three are equal, and  not equal otherwise.
* */

public class Algs_1_1_3
{
    public static void main(String[] args)
    {
        int arg1 = Integer.valueOf(args[0]);
        int arg2 = Integer.valueOf(args[1]);
        int arg3 = Integer.valueOf(args[2]);

        boolean equals = arg1 == arg2 && arg2 == arg3;
        System.out.println(equals ? "equal" : "not equal");
    }
}