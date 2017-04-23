package com.jayanthi.stacks;

import java.util.Scanner;
import java.util.Stack;

public class MaxVal {

    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> maxStack = new Stack<Integer>();

    public void push(Integer val) {
        stack.push(val);
        if (maxStack.empty() || val > maxStack.peek() ) {
            maxStack.push(val);
        }
    }

    public Integer pop() {
        if (stack.peek() == maxStack.peek()) {
            maxStack.pop();
        }
        return stack.pop();
    }

    public Integer getMax() {
        return maxStack.peek();
    }

    public static void main(String[] args) {
        MaxVal max = new MaxVal();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String[] values = new String[t];
        for (int i = 0; i < t; i++) {
            max.push(in.nextInt());
        }

        System.out.print(max.getMax());
        max.pop();
        System.out.print(max.getMax());
    }
}
