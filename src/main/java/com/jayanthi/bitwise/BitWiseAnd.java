package com.jayanthi.bitwise;

import java.util.Scanner;

public class BitWiseAnd {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            System.out.println(((k-1) | k) <= n ? k-1 : k-2);

        }

    }

    private static int getMax(int n, int k) {
        int max = 0;
        for (int i=1; i<n; i++) {
            int val = i & (i + 1);
            if (((k-1) | k) <= n) {
                max = val;
            }
        }
        return max;
    }
}
