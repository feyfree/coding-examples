package com.feyfree.leetcode.p208;

class Trie {

    private static final int R = 26;

    private Node root;

    private static class Node {
        private char val;
        private Node[] next = new Node[R];
        private boolean isWord;

        private Node() {
        }

        Node(char c) {
            Node node = new Node();
            node.val = c;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new Node();
        root.val = ' ';
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.next[c - 'a'] == null) {
                ws.next[c - 'a'] = new Node(c);
            }
            ws = ws.next[c - 'a'];
        }
        ws.isWord = true;
    }


    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.next[c - 'a'] == null) {
                return false;
            }
            ws = ws.next[c - 'a'];
        }
        return ws.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node ws = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (ws.next[c - 'a'] == null) {
                return false;
            }
            ws = ws.next[c - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
