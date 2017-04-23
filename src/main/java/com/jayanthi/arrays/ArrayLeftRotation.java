package com.jayanthi.arrays;

import java.util.Scanner;

public class ArrayLeftRotation {

    public static int[] arrayLeftRotation(int[] a, int n, int k) {
        int[] temp = new int[k];
        for (int i=0; i<k;i++) {
            temp[i] = a[i];
        }

        int i;
        for (i=k;i<n;i++) {
            a[i-k] = a[i];
        }

        i = i - k;
        for (int number : temp) {
            a[i++]=number;
        }

//        for (int i=n-k,j=0; i<=k; i++,j++) {
//            a[i]=temp[j];
//        }
        return a;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");

        System.out.println();

    }
}
