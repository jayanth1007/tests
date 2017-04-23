package com.jayanthi.arrays.subarrays;

import java.util.Scanner;

public class SubArraySumNegative {

    private static int[] A;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        A = new int[n];
        for (int i=0; i< n; i++) {
            A[i] = scanner.nextInt();
        }

        int counter = 0;
        for (int i=1; i<=n; i++) {
            for (int j=0; j<n;j++) {
                if (j+i > n) {
                    break;
                }
                if (sum(j, j+i) < 0) {
                    counter++;
                }
            }
        }

        System.out.println(counter);
    }

    private static int sum(int i, int j) {
        int total = 0;
        for (int k=i; k<j; k++) {
            total += A[k];
        }
        return total;
    }
}