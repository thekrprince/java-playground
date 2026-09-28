import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();

        for(int i=0; i<strs.length; i++) {
            int[] count = new int[26];
            
            for(char ch: strs[i].toCharArray()) {
                int diff = ch - 'a';
                count[diff]++;
            }

            StringBuilder sb = new StringBuilder();
            for(int num: count) {
                sb.append(num).append("#");
            }
            String key = sb.toString();
            if(!ans.containsKey(key)) {
                ans.put(key, new ArrayList<>());
            }
            ans.get(key).add(strs[i]);
        }

        return new ArrayList<>(ans.values());
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] str1 = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> ans = sol.groupAnagrams(str1);
        System.out.println(ans);
    }
}