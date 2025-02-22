import java.util.Map;
class Solution {
    Map<Long, String> map;
    public String smallestNumber(String num, long t) {
        map = new HashMap<>();
        String min = getMin(t);
        if (min.isEmpty()) return "-1";
        if (min.length() > num.length() || (min.length() == num.length() && min.compareTo(num) >= 0)) return min;
        int len = num.length();
        long[] remain = new long[len];
        int[] digit = new int[len];
        remain[0] = t;
        digit[0] = num.charAt(0) - '0';
        int p = 0;
        while (p < len - 1 && digit[p] > 0) {
            remain[p + 1] = findRemain(remain[p], digit[p]);
            p++;
            digit[p] = (int)(num.charAt(p) - '0');
        }
        while (p >= 0) {
            if (p == len - 1) {
                for (int i = Math.max(digit[p], 1); i <10; i++) {
                    if (i % remain[p] == 0) return num.substring(0, len - 1) + i;
                }
            } else {
                for (int i = digit[p] + 1; i < 10; i++) {
                    String temp = getMin(findRemain(remain[p], i));
                    // System.out.println("temp "+ p + " " + i + " " + temp);
                    int temp_len = temp.length();
                    if (temp_len < len - p) {
                        StringBuilder sb = new StringBuilder(num.substring(0, p));
                        sb.append(i);
                        for (int j = 0; j < len - p -1 - temp_len; j++) sb.append(1);
                        sb.append(temp);
                        return sb.toString();
                    }
                }
            }
            p--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len + 1 - min.length(); i++) sb.append(1);
        sb.append(min);
        return sb.toString();
    }
    private String getMin(long n) {
        if (map.get(n) != null) {
            // System.out.println("min " + n + " " + map.get(n));
            return map.get(n);
        }
        int[] d = new int[10];
        long k = n;
        for (int i = 9; i > 1; i--) {
            while (k % i == 0) {
                d[i]++;
                k /= i;
            }
        }
        if (k > 1) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < 10; i++) {
            for (int j = 0; j < d[i]; j++) sb.append(i);
        }
        String s = sb.toString();
        // System.out.println("min " + n + " " + s);
        map.put(n, s);
        return s;
    }
    private long findRemain(long a, int b) {
        long max = Math.max(a, b * 1L);
        long min = Math.min(a, b * 1L);
        while (min > 0) {
            long temp = min;
            min = max % min;
            max = temp;
        }
        return a/max;
    }
}
