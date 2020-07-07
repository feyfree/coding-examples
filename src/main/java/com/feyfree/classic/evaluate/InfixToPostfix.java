package com.feyfree.classic.evaluate;


/******************************************************************************
 *  Compilation:  javac InfixToPostfix.java
 *  Execution:    java InfixToPostFix
 *  Dependencies: Stack.java StdIn.java StdOut.java
 *
 *  Reads in a fully parenthesized infix expression from standard input
 *  and prints an equivalent postfix expression to standard output.
 *
 *  Windows users: replace [Ctrl-d] with [Ctrl-z] to signify end of file.
 *
 *  % java InfixToPostfix
 *  ( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )
 *  [Ctrl-d]
 *  2 3 4 + 5 6 * * +
 *
 *  % java InfixToPostfix
 *  ( ( ( 5 + ( 7 * ( 1 + 1 ) ) ) * 3 ) + ( 2 * ( 1 + 1 ) ) )
 *  5 7 1 1 + * + 3 * 2 1 1 + * +
 *
 *  % java InfixToPostfix | java EvaluatePostfix
 *  ( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )
 *  [Ctrl-d]
 *  212
 *
 ******************************************************************************/


import com.feyfree.algs4.Stack;
import com.feyfree.algs4.StdIn;
import com.feyfree.algs4.StdOut;

/**
 * 前缀表达转后缀表达
 *
 * @author leilei
 */
public class InfixToPostfix {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if ("+".equals(s)) {
                stack.push(s);
            } else if ("*".equals(s)) {
                stack.push(s);
            } else if (")".equals(s)) {
                StdOut.print(stack.pop() + " ");
            } else if ("(".equals(s)) {
                StdOut.print("");
            } else {
                StdOut.print(s + " ");
            }
            StdOut.println();
        }
    }
}
