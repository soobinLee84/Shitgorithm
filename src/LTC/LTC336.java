package LTC;

import java.util.ArrayList;
import java.util.List;

public class LTC336 {

    public List<List<Integer>> palindromePairs(String[] words) {

        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.insert(i, words[i]);
        }

        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            results.addAll(trie.search(i, words[i]));
        }

        return results;

    }


    static class TrieNode {
        int wordId;
        TrieNode[] children;
        List<Integer> pIds;

        public TrieNode() {
            this.wordId = -1;
            children = new TrieNode[26];  // 알파벳
            pIds = new ArrayList<>();
        }
    }

    static class Trie {

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public boolean isP(String word, int start, int end) {

            while (start < end) {
                if (word.charAt(start++) != word.charAt(end--)) {
                    return false;
                }
            }

            return true;
        }

        public void insert(int index, String word) {
            TrieNode cur = root;

            // 트라이에 단어 거꾸로 추가
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);

                // 앞쪽 단어가 팰린드롬인 경우 해당 위치에서 pIds 저장 aaabc
                if (isP(word, 0, i)) {
                    cur.pIds.add(index);
                }

                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }

                cur = cur.children[c - 'a'];
            }

            cur.wordId = index;
        }

        public List<List<Integer>> search(int index, String word) {
            List<List<Integer>> result = new ArrayList<>();

            TrieNode cur = root;

            for (int i = 0; i < word.length(); i++) {

                // word : abcdddd | 트라이 : abc
                if (cur.wordId >= 0 && isP(word, i, word.length() - 1)) {
                    result.add(List.of(index, cur.wordId));
                }

                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null)
                    return result;

                cur = cur.children[c - 'a'];
            }

            // word : ab || 트라이 : ccccba
            for (int p : cur.pIds) {
                result.add(List.of(index, p));
            }

            // 완전 반대 팰린드롬
            if (cur.wordId >= 0 && cur.wordId != index) {
                result.add(List.of(index, cur.wordId));
            }

            return result;
        }

    }
}
