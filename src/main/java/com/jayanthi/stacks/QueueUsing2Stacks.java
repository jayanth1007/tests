package com.jayanthi.stacks;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsing2Stacks {

    public static void main(String[] args) {
        Stack<Integer> front = new Stack();
        Stack<Integer> rear = new Stack();
        Scanner scanner = new Scanner(System.in);
        int noOfLines = Integer.parseInt(scanner.nextLine());

        String inputLine;
        for (int i =0; i < noOfLines; i++) {
            inputLine = scanner.nextLine();
            String[] tokens = inputLine.split(" ");
            int type = Integer.parseInt(tokens[0]);
            switch (type) {
                case 1 :
                    rear.push(Integer.parseInt(tokens[1]));
//                    while (!rear.isEmpty()) {
//                        front.add(rear.pop());
//                    }
//                    front.push(Integer.parseInt(tokens[1]));
//                    rear.clear();
//                    while (!front.isEmpty()) {
//                        rear.add(front.pop());
//                    }
                    break;
                case 2 :
                    if (front.empty()) {
                        while(!rear.empty()) {
                            front.push(rear.pop());
                        }
                    }
                    front.pop();
                    break;
                case 3 :
                    if (front.empty()) {
                        while(!rear.empty()) {
                            front.push(rear.pop());
                        }
                    }
                    System.out.println(front.peek());
            }
        }
    }
}