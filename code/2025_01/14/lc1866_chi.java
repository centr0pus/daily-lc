class Solution {
    private int mod = 1000000007;
    public int rearrangeSticks(int n, int k) {
        long[] count = new long[k + 1];
        count[1] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = Math.min(k, i + 1); j > 0; j--) {
                count[j] = (i * count[j] + count[j - 1]) % mod;
            }
        }
        return (int) count[k];
    }
}
