package com.jayanthi.regex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class EmailMatch {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<String> names = new ArrayList<String>();
        for(int a0 = 0; a0 < N; a0++){
            String firstName = in.next();
            String emailID = in.next();

            String pattern = "\\[w.]*@gmail.com";
            if (emailID.matches(pattern)) {
                names.add(firstName);
            }
        }

        Collections.sort(names);
        for (String name : names) {
            System.out.println(name);
        }
    }
}
