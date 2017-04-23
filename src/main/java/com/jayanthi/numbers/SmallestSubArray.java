package com.jayanthi.numbers;

import java.util.Scanner;

/**
 * Created by m808421 on 3/7/17.
 */
public class SmallestSubArray {

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();
        for(int i = 0; i < testCases; i++) {
            int arrLength = input.nextInt();
            int xValue = input.nextInt();
            int[] arr = new int[arrLength];
            for (int j = 0; j < arrLength; j++) {
                arr[j] = input.nextInt();
            }
            System.out.println(findMinSubarray(arr, xValue));
        }
        input.close();
    }

    public static int findMinSubarray(int[] array, int x) {
        int currentMin = array.length + 1;
        for (int i=0; i < array.length; i++) {
            if (array[i] > x) {
                currentMin = 1;
                break;
            }

            int sum = array[i];
            int nextIndex = i + 1;
            while (sum <= x && nextIndex < array.length) {
                sum += array[nextIndex];
                nextIndex++;
            }

            if (sum > x && (nextIndex - i < currentMin)) {
                currentMin = nextIndex - i;
            }
        }
        return currentMin;
    }
}
