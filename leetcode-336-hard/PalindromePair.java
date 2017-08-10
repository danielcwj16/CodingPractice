/**
 * Interative solution will not pass big test cases
 * 
 * http://blog.csdn.net/foreverling/article/details/51424643
 * 
 * 
 */

import java.util.*;

public class PalindromePair {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        List<List<Integer>> indices = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 0) {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (isPalindrome(entry.getKey())) {
                        addAll(indices, i, entry.getValue());
                    }
                }
            }

            for (int j = 0; j < words[i].length(); j++) {
                String front = words[i].substring(0, j);
                String back = words[i].substring(j, words[i].length());
                String rfront = reverse(front);
                String rback = reverse(back);
                if (isPalindrome(front) && map.containsKey(rback)) {
                    addAll(indices, map.get(rback), i);
                }
                if (isPalindrome(back) && map.containsKey(rfront)) {
                    addAll(indices, i, map.get(rfront));
                }
            }
        }
        return indices;
    }

    private void addAll(List<List<Integer>> indices, int a, int b) {
        if (a == b) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        indices.add(list);
    }

    private String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }

    private boolean isPalindrome(String word) {
        for (int i = 0, j = word.length() - 1; i < j; i++, j--) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}