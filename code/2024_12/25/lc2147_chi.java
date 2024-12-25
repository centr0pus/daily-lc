class Solution {
    public int numberOfWays(String corridor) {
        int l = 0, r = corridor.length() - 1;
        while (l <= r && corridor.charAt(l) == 'P') l++;
        if (l > r) return 0;
        while (r > 0 && corridor.charAt(r) == 'P') r--;
        boolean possible = true;
        long ans = 1L;
        while (l <= r) {
            if (corridor.charAt(l) == 'S') {
                possible = !possible;
                l++;
                if (possible && l < r) {
                    int count = 1;
                    while (corridor.charAt(l) == 'P') {
                        count++;
                        l++;
                    }
                    ans = (ans * count) % 1000000007;
                }
            } else l++;
        }
        return possible ? (int)ans : 0;
    }
}