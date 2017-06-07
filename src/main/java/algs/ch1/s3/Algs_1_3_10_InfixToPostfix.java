package algs.ch1.s3;

/*
    1.3.10  Write a filter  InfixToPostfix that converts an arithmetic expression from in-
    fix to postfix.
    
* */

import edu.princeton.cs.algs4.Stack;

public class Algs_1_3_10_InfixToPostfix
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

                expression.push("( " + operand1 + " " + operand2 + " " + operator + " )");
            }
            else
                expression.push(item);
        }

        for (String exp : expression)
            System.out.print(exp + " ");
    }
}
