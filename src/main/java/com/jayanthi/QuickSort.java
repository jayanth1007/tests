package com.jayanthi;

import java.util.Random;

public class QuickSort {

    private final static int SIZE = 7;
    private final static int MAX = 20;
    private static int[] numbers;

    public static void main(String[] args) {
        numbers = new int[SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        }
    }

    private static void quickSort(int[] numbers, int min, int high) {
        int pivot = min + (high - min) /2;
        int i = 0, j=0;

        while (i <= j) {
            while (numbers[i] < numbers[pivot]) {
                i++;
            }

            while (numbers[j] > numbers[pivot]) {
                j--;
            }

            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }

        if (min < j) {
            quickSort(numbers, min, j);
        }

        if (i < high) {
            quickSort(numbers, i, high);
        }
    }

    private static void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
