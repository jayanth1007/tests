package com.jayanthi.stacks;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    public static String isBalanced(String expression) {
        Stack<Character> stack = new Stack();
        int i;
        outer: for (i = 0; i< expression.length(); i++) {
            char brace = expression.charAt(i);
            switch (brace) {
                case '(':
                case '{':
                case '[':
                    stack.push(brace);
                    break;

                case ')':
                case '}':
                case ']':
                    if (stack.empty()) {
                        break outer;
                    }
                    char pop = stack.pop();
                    if (')' == brace && '(' == pop) {
                        continue;
                    }

                    if ('}' == brace && '{' == pop) {
                        continue;
                    }

                    if (']' == brace && '[' == pop) {
                        continue;
                    }
                    break outer;

            }


        }
        return i == expression.length() && stack.isEmpty() ? "YES" : "NO";
    }

    static String[] braces(String[] values) {

        String[] output = new String[values.length];
        for (int i=0; i<values.length; i++) {
            output[i]= isBalanced(values[i]);
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String[] values = new String[t];
        for (int i = 0; i< t; i++) {
            values[i] = in.next();
        }

//        for (int a0 = 0; a0 < t; a0++) {
//            String expression = in.next();
//            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
//        }
        
        System.out.println(braces(values));
    }
}
