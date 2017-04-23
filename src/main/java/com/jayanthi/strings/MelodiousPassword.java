package com.jayanthi.strings;

import java.util.Scanner;

/**
 * Jeremy and Clara are learning about passwords and created a game to test their "hacking" skills. Jeremy made rules for valid passwords and Clara needs to write a program to generate all possible passwords that meet those rules. Jeremy's rules are these:

 a password consists of exactly  lowercase English letters.
 the password is melodious, meaning that consonants can only be next to vowels and vowels can only be next to consonants. Example: bawahaha
 the password cannot contain the letter  (because it's both a consonant and vowel).
 the first letter of the password can be either a vowel or consonant.
 image
 Given the length, , of the password, output all of the possible passwords that meet the conditions above. Your output will be considered correct if and only if it contains all melodious passwords of length n.
 */
public class MelodiousPassword {

    private static char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
    private static char[] consonants = new char[]{'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm',
            'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
    private static int length;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        length = in.nextInt();
        getPassword("", 0, 0);
    }

    private static void getPassword(String currentPass, int vowIndex, int consIndex) {
        if (currentPass.length() == length) {
            System.out.println(currentPass);
            currentPass = currentPass.substring(0, currentPass.length() - 2);
        }

        if (vowIndex == vowels.length - 1 && consIndex == consonants.length - 1) {
            return;
        } else if (consIndex == consonants.length - 1) {
            consIndex = 0;
            vowIndex--;
        } else {
            consIndex++;
        }

        getPassword(currentPass, vowIndex, consIndex);
    }
}
