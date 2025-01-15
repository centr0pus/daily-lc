class Solution {
    public long minimumSteps(String s) {
        long ans = 0L;
        int point = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '0') {
                ans += (i - point);
                point++;
            }
        }
        return ans;
    }
}
