package com.jayanthi.strings;

/**
 * Created by m808421 on 4/22/17.
 */
public class Tries {

    private TrieNode root = new TrieNode();

    public static void main(String[] args) {
        Tries tries = new Tries();
        tries.insert("GEEKS");
        tries.insert("FOR");
        tries.insert("QUIZ");
        tries.insert("GO");
        System.out.println(tries.search("GEEKS"));
    }

    class TrieNode {
        char val;
        TrieNode left, mid, right;
        boolean end = false;

        public TrieNode() {

        }

        public TrieNode(char val) {
            this.val = val;
        }
    }

    private void insert(String word) {
        if (word != null && !word.isEmpty())
            insert(word, 0, root);
    }

    private TrieNode insert(String word, int index, TrieNode node) {
        char ch = word.charAt(index);
        if (node == null) {
            node = new TrieNode(ch);
        }
        if (ch < node.val) node.left = insert(word, index, node.left);
        else if (ch > node.val) node.right = insert(word, index, node.right);
        else if (index < word.length() - 1) node.mid = insert(word, index + 1, node.mid);
        else node.end = true;
        return node;
    }

    public boolean search(String word) {
        if (word == null || word.isEmpty()) return false;
        return search(word, 0, root);
    }

    private boolean search(String word, int index, TrieNode node) {
        if (node == null) return false;
        char ch = word.charAt(index);
        if (ch < node.val) return search(word, index, node.left);
        if (ch > node.val) return search(word, index, node.right);
        if (index < word.length() - 1) return search(word, index + 1, node.mid);
        return node.end;
    }
}
