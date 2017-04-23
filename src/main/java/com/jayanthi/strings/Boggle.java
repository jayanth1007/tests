package com.jayanthi.strings;

import java.util.*;

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

 The idea is to consider every character as a starting character and find all words starting with it. All words starting from a character can be found using Depth First Traversal. We do depth first traversal starting from every cell. We keep track of visited cells to make sure that a cell is considered only once in a word.*
 */
class Boggle {

    static Set<String> dic = new HashSet<String>();

    static void makeSet() {
        dic.add("GEEKS");
        dic.add("FOR");
        dic.add("QUIZ");
        dic.add("GO");
    }

    static boolean isValidWord(String str) {
        return dic.contains(str);
    }

    static void DFSUtil(char[][] boggle, boolean[][] visited, int i, int j, String str) {
        visited[i][j] = true;
        str += boggle[i][j];

        if(isValidWord(str))
            System.out.println(str);

        for(int row=i-1;row<=i+1 && row<boggle.length;row++) {
            for(int col=j-1;col<=j+1 && col<boggle[0].length;col++) {
                if(row>=0 && col >= 0 && !visited[row][col])
                    DFSUtil(boggle,visited,row,col,str);
            }
        }
        visited[i][j] = false;
    }

    static void printWords(char[][] boggle) {
        int M = boggle.length;
        int N = boggle[0].length;

        boolean[][] visited = new boolean[M][N];
        String str = "";

        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++)
                DFSUtil(boggle,visited,i,j,str);
        }
    }

    static void printMatrix(char[][] boggle) {
        for(int i=0;i<boggle.length;i++) {
            for(int j=0;j<boggle[0].length;j++)
                System.out.print(boggle[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {

        makeSet();

        char[][] boggle = {{'G','I','Z'},
                {'U','E','K'},
                {'Q','S','E'}};

        System.out.println("Boggle:");
        printMatrix(boggle);

        System.out.println("\nWords:");
        printWords(boggle);
    }
}