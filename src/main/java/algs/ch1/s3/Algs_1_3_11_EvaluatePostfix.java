package algs.ch1.s3;

/*
    1.3.11  Write a program  EvaluatePostfix that takes a postfix expression from stan-
    dard input, evaluates it, and prints the value. (Piping the output of your program from
    the previous exercise to this program gives equivalent behavior to  Evaluate
    
* */

import edu.princeton.cs.algs4.Stack;

public class Algs_1_3_11_EvaluatePostfix
{
    public static void main(String[] args) throws Exception
    {
        String input = "( ( 1 2 + ) ( ( 3 4 - ) ( 5 6 - ) * ) * )";

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
                String open = expression.pop();

                String result = "";
                int op1 = Integer.valueOf(operand1.trim());
                int op2 = Integer.valueOf(operand2.trim());
                if (operator.equals("+"))
                    result = String.valueOf(op1 + op2);
                if (operator.equals("-"))
                    result = String.valueOf(op1 - op2);
                if (operator.equals("*"))
                    result = String.valueOf(op1 * op2);
                if (operator.equals("/"))
                    result = String.valueOf(op1 / op2);

                expression.push(result);
            }
            else
                expression.push(item);
        }

        for (String exp : expression)
            System.out.print(exp + " ");
    }
}
