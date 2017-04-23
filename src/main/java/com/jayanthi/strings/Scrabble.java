package com.jayanthi.strings;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 Given a dictionary, a method to do lookup in dictionary and a M x N board where every cell has one character. Find all possible words that can be formed by a sequence of adjacent characters. Note that we can move to any of 8 adjacent characters, but a word should not have multiple instances of same cell.

 Example:

 Input: dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
 boggle[][]   = {{'G','I','Z'},
 {'U','E','K'},
 {'Q','S','E'}};
 isWord(str): returns true if str is present in dictionary
 else false.

 Output:  Following words of dictionary are present
 GEEKS
 QUIZ
 Boggle

 We strongly recommend that you click here and practice it, before moving on to the solution.

 The idea is to consider every character as a starting character and find all words starting with it. All words starting from a character can be found using Depth First Traversal. We do depth first traversal starting from every cell. We keep track of visited cells to make sure that a cell is considered only once in a word.
 */
public class Scrabble {

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine().trim());
        for (int t=testCases-1; t>=0; t--) {
            int wordCount = Integer.parseInt(in.nextLine().trim());
            String[] words = in.nextLine().trim().split(" ");
            String[] dimensions = in.nextLine().trim().split(" ");
            int n = Integer.parseInt(dimensions[0]);
            int m = Integer.parseInt(dimensions[1]);
            char[][] matrix = new char[n][m];
            char[] line = in.nextLine().trim().replaceAll(" ", "").toCharArray();
            int lineIndex = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    matrix[i][j] = line[lineIndex++];
                }
            }
            Set<String> result = new TreeSet<String>();
            outer:for(int k = 0; k <words.length; k++){
                for(int i=0; i<n; i++){
                    for(int j=0; j<m; j++){
                        if(words[k].charAt(0) == matrix[i][j]){
                            boolean[][] mat = new boolean[n][m];
                            recurse(n, m, matrix,i, j, words[k],0,  "", result, mat);
                            if(result.contains(words[k]))
                                continue outer;
                        }
                    }
                }
            }
            for(String st: result){
                System.out.print(st+" ");
            }
            if(result.size()==0){
                System.out.print(-1);
            }
            System.out.print("\n");
        }
    }

    private static void recurse(int n, int m, char[][] matrix,int i, int j, String word,  int wordIndex, String string, Set<String> result, boolean[][] mat) {
        if(word.equals(string) && !result.contains(word)){
            result.add(string);return;
        }
        if(i>=0 && i<n && j>=0 && j<m && wordIndex<word.length() &&matrix[i][j]==word.charAt(wordIndex) && mat[i][j] == false){
            mat[i][j] = true;
            string+=matrix[i][j];
            recurse(n, m, matrix, i+1, j, word, wordIndex+1, string, result, mat);
            recurse(n, m, matrix, i, j+1, word, wordIndex+1, string, result, mat);
            recurse(n, m, matrix, i-1, j, word, wordIndex+1, string, result, mat);
            recurse(n, m, matrix, i, j-1, word, wordIndex+1, string, result, mat);
            recurse(n, m, matrix, i+1, j+1, word, wordIndex+1, string, result, mat);
            recurse(n, m, matrix, i+1, j-1, word, wordIndex+1, string, result, mat);
            recurse(n, m, matrix, i-1, j-1, word, wordIndex+1, string, result, mat);
            recurse(n, m, matrix, i-1, j+1, word, wordIndex+1, string, result, mat);
        }
    }

}