package Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



class TrieNode {
    boolean isWord;
    TrieNode[] childTrieNodes = new TrieNode[26];

    public TrieNode() {
        isWord = false;
        Arrays.fill(childTrieNodes, null);
    }
}

class TrieT {
    public TrieNode root;

    public TrieT() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode temp = root;
        for (char i : word.toCharArray()) {
            if (temp.childTrieNodes[i - 'a'] == null) {
                temp.childTrieNodes[i - 'a'] = new TrieNode();
            }
            temp = temp.childTrieNodes[i - 'a'];
        }
        temp.isWord = true;
    }
}

class Solution {
    public static int[][] delta = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public List<String> findWords(char[][] board, String[] words) {
        TrieT trie1 = new TrieT();
        Arrays.stream(words).forEach(x -> trie1.insert(x));
        Set<String> result = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(trie1.root, board, i, j, "", result);
            }
        }
        return new ArrayList<>(result);
    }

    public void dfs(TrieNode t, char[][] board, int x, int y, String currentWord, Set<String> result) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] == ' '
                || t.childTrieNodes[board[x][y] - 'a'] == null)
            return;
        char temp = board[x][y];
        if (t.childTrieNodes[temp - 'a'].isWord)
            result.add(currentWord + temp);

        board[x][y] = ' ';
        for (int i = 0; i < 4; i++) {
            int X = x + delta[i][0];
            int Y = y + delta[i][1];

            dfs(t.childTrieNodes[temp - 'a'], board, X, Y, currentWord + temp, result);

        }
        board[x][y] = temp;
    }
}


public class Word_Search_2{
    public static void main(String[] args) {
        System.out.println(new Solution()
                .findWords(new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
                        { 'i', 'f', 'l', 'v' } }, new String[] { "oath", "pea", "eat", "rain" }));
    }
}