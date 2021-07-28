package com.avantica.tutorial.algorithmsdatastructures.stack;

public class InfixToPrefix {
    public String convert(String infix){
        MyStack<String> operandsStack = new MyStack<String>();
        MyStack<String> operatorsStack = new MyStack<String>();
        for (String character: infix.split("")) {
            if (!IsOperand(character))
            {
                operandsStack.push(character);
            }
            else if ("(".equals(character) || operandsStack.isEmpty() || Precedence(character) > Precedence(operandsStack.peek()))
            {
                operatorsStack.push(character);
            }
            else if (")".equals(character))
            {
                while (!"(".equals(operatorsStack.peek()))
                {
                    operandsStack.push(MergeOperation(operatorsStack, operandsStack));
                }
                operatorsStack.pop();
            }
            else if (Precedence(character) <= Precedence(operatorsStack.peek()))
            {
                while (!operatorsStack.isEmpty() && Precedence(character) <= Precedence(operatorsStack.peek()))
                {
                    operandsStack.push(MergeOperation(operatorsStack, operandsStack));
                }
                operatorsStack.push(character);
            }
        }

        while (!operatorsStack.isEmpty())
        {
            operandsStack.push(MergeOperation(operatorsStack, operandsStack));
        }
        return operandsStack.peek();
    }

    private static boolean IsOperand(String character)
    {
        return "+".equals(character) ||
                "-".equals(character) ||
                "*".equals(character) ||
                "/".equals(character) ||
                "(".equals(character) ||
                ")".equals(character);
    }

    private static int Precedence(String character)
    {
        if ("*".equals(character) || "/".equals(character))
        {
            return 2;
        }
        else if ("+".equals(character) || "-".equals(character))
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    private static String MergeOperation(Stack<String> operatorStack, Stack<String> operandStack)
    {
        String operator = operatorStack.pop();
        String rightOperand = operandStack.pop();
        String leftOperand = operandStack.pop();
        String operand = "(" + operator + leftOperand + rightOperand + ")";
        return operand;
    }
}
