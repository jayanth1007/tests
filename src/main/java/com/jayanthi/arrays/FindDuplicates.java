package com.jayanthi.arrays;

/**
 * Created by m808421 on 2/19/17.
 */
public class FindDuplicates {

    void printRepeating(int arr[], int size) {
        for (int i=0; i < size; i++) {
            if (arr[Math.abs(arr[i])] <= 0) {
                System.out.println(Math.abs(arr[i]));
            } else {
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            }
        }
    }

    /* Driver program to test the above function */
    public static void main(String[] args)
    {
        FindDuplicates duplicate = new FindDuplicates();
        int arr[] = {4, 2, 4, 5, 2, 3, 1};
        int arr_size = arr.length;
        duplicate.printRepeating(arr, arr_size);
    }
}
