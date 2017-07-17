/**
 * Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.
 */
import java.util.*;
public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0)
            return res;
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        for (int i = 0; i < strs.length; i++) {
            char[] carray = strs[i].toCharArray();
            Arrays.sort(carray);
            String s = new String(carray);
            if (map.containsKey(s)) {
                ArrayList<String> st = map.get(s);
                st.add(strs[i]);
                map.put(s, st);
            } else {
                ArrayList<String> sl = new ArrayList<String>();
                sl.add(strs[i]);
                map.put(s, sl);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}