package com.jayanthi.numbers;

import java.util.Scanner;

/**
 * Created by m808421 on 3/7/17.
 */
public class TripletsWithSumZero {

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();
        for(int i = 0; i < testCases; i++) {
            int arrLength = input.nextInt();
            int[] arr = new int[arrLength];
            for (int j = 0; j < arrLength; j++) {
                arr[j] = input.nextInt();
            }
            findTriplets(arr, arr.length);
        }
        input.close();
    }

    public static void findTriplets(int arr[] , int n)
    {
        int count = 0;
        for (int i=0; i<n-3; i++) {
            int sum=0;
            for (int j=i; j<i+3;j++) {
                sum+=arr[j];
            }
            if (sum==0) {
                count++;
            }
        }
    }
}
