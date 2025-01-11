class Solution {
    public int minimizedStringLength(String s) {
       boolean[] found = new boolean[26];
       int ans = 0;
       for (char c : s.toCharArray()) {
            if (!found[c - 'a']) {
                found[c - 'a'] = true;
                ans++;
            }
       } 
       return ans;
    }
}