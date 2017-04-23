package com.jayanthi.stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by m808421 on 1/25/17.
 */
public class BalancedBracketsNoNumber {

    public static boolean isBalanced(String expression) {
        boolean balanced = false;
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
        return i == expression.length() && stack.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input=sc.next();
            System.out.println( (isBalanced(input)) ? "true" : "false" );
        }
    }
}
