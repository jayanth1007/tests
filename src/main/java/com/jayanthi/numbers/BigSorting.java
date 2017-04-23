package com.jayanthi.numbers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BigSorting {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsorted[unsorted_i] = in.next();
        }

        Arrays.sort(unsorted, new MyComparator());

        Arrays.sort(unsorted, new MyComparator());
        for (String number : unsorted) {
            System.out.println(number);
        }
    }

    static class MyComparator implements Comparator<String> {

        public int compare(String o1, String o2) {
            int length1 = o1.length();
            int length2 = o2.length();
            if (length1 != length2) {
                return length1 < length2 ? -1 : 1;
            } else {
                int i=0;
                while (i < length1 && i < length2 && o1.substring(i, i+1).equals(o2.substring(i, i+1))) {
                    i++;
                }

                if (i == length1 || i == length2) {
                    return 0;
                }
                return o1.substring(i, i+1).compareTo(o2.substring(i, i+1));
            }
        }
    }
}
