package com.jayanthi.numbers;

import java.util.Scanner;

public class PrimeNumbers {

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i=0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int number : numbers) {
            System.out.println(isPrime(number));
        }
    }

    private static String isPrime(int number) {
        if (number == 1) {
            return "Not Prime";
        }
        for (int i=2; i <= number /2; i++) {
            if (number % i == 0) {
                return "Not prime";
            }
        }
        return "Prime";
    }
}
