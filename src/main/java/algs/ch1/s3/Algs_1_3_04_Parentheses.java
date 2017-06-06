package algs.ch1.s3;

/*
    1.3.4  Write a stack client  Parentheses that reads in a text stream from standard input
    and uses a stack to determine whether its parentheses are properly balanced. For ex-
    ample, your program should print  true for  [()]{}{[()()]()} and  false for [(]) .
* */

import edu.princeton.cs.algs4.Stack;

public class Algs_1_3_04_Parentheses
{
    public static void main(String[] args) throws Exception
    {
        String valid = "[()]{}{[()()]()}";
        String invalid = "[(])";

        System.out.println(isBalanced(valid));
        System.out.println(isBalanced(invalid));
    }

    private static boolean isBalanced(String input)
    {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++)
        {
            String aChar = input.substring(i, i+1);
            if ("[({".contains(aChar))
                stack.push(aChar);
            if ("])}".contains(aChar))
            {
                String popped = stack.pop();
                if ("[({".indexOf(popped) != "])}".indexOf(aChar))
                    return false;
            }
        }
        return true;
    }
}
