package algs.ch1.s3;

/*
    1.3.9  Write a program that takes from standard input an expression without left pa-
    rentheses and prints the equivalent infix expression with the parentheses inserted. For
    example, given the input:
    1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
    your program should print
    ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) )

    note: unable to figure this out. gave up and looked at
    https://github.com/morrxy/algs4/blob/master/exercise/1.3.09/LeftParentheses.java
    to see how someone else approached it
* */

import edu.princeton.cs.algs4.Stack;

public class Algs_1_3_09_ParenInserter
{
    public static void main(String[] args) throws Exception
    {
        String input = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";

        Stack<String> ops = new Stack<>();
        Stack<String> expression = new Stack<>();
        for (String item : input.split(" "))
        {
            if ("+-*/".contains(item))
                ops.push(item);
            else if (item.equals(")"))
            {
                String operator = ops.pop();
                String operand2 = expression.pop();
                String operand1 = expression.pop();

                expression.push("( " + operand1 + " " + operator + " " + operand2 + " )");
            }
            else
                expression.push(item);
        }

        for (String exp : expression)
            System.out.print(exp + " ");
    }
}
