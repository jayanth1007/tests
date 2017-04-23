package com.jayanthi.numbers;

import java.util.Scanner;

/**
 * Created by m808421 on 3/5/17.
 */
public class XPowerY {


    public static void main(String[] strings) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int result = 1;
        int power = x;
        while (y != 0) {
            if ((y & 1) == 1) {
                result *= power;
            }
            y >>= 1;
            power *= power;
        }
        System.out.println(result);
    }

}
