import java.util.List;
import java.util.ArrayList;
class Solution {
    public static final int MOD = 1000000007;
    public int possibleStringCount(String word, int k) {
        int segment = 0, start = 0;
        List<Integer> dup = new ArrayList<>();
        char[] charArr = word.toCharArray();
        for (int i = 1; i <= charArr.length; i++) {
            if (i == charArr.length || charArr[i] != charArr[i -1]) {
                segment++;
                dup.add(i - start);
                start = i;
            }
        }
        long total = 1L;
        for (Integer count : dup) {
            total = (total * count) % MOD;
        }
        if (segment >= k) return (int)total;
        int[] impossible = new int[k - segment];
        impossible[0] = 1;
        int max = 0;
        for (Integer count : dup) {
            if (count == 1) continue;
            max = Math.min(max + count - 1, impossible.length - 1);
            int sum = 0;
            for (int i = Math.max(0, max - count + 2); i <= max; i++) sum = (sum + impossible[i]) % MOD;
            for (int i = max; i > 0; i--) {
                int temp = impossible[i];
                if (i - count + 1 >= 0) sum = (sum + impossible[i - count + 1]) % MOD;
                impossible[i] = sum;
                sum = (sum >= temp) ? (sum - temp) : (sum + MOD - temp);
            }
        }
        for (int i = 0; i < impossible.length; i++) {
            total = total - impossible[i];
            if (total < 0) total += MOD;
        }
        return (int) (total % MOD);
    }
}
