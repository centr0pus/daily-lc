class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long ab = lcm((long)a, (long)b);
        long bc = lcm((long)b, (long)c);
        long ac = lcm((long)a, (long)c);
        long abc = lcm(ab, (long)c);
        long cycle = abc/a + abc/b + abc/c - abc/ab - abc/bc - abc/ac + 1;
        // System.out.println(ab + " " + bc + " " + ac + " " + abc);
        int r = (int)(n % cycle);
        long left = 1L, right = Math.min(abc - 1, 2000000000L), temp = 0L;
        // System.out.println(left + " " + right + " " + temp + " " + r);
        while (left <= right) {
            // System.out.println(left + " " +right);
            long mid = (left + right)/2;
            long count = mid/a + mid/b + mid/c - mid/ab - mid/bc - mid/ac;
            if (count == r) {
                temp = mid - min(mid % a, mid % b, mid % c);
                break;
            } else if (count > r) right = mid - 1 - min((mid - 1) % a, (mid - 1) % b, (mid -1) % c);
            else left = mid + min(a - mid % a, b - mid % b, c - mid % c);
        }
        return (int)(n/cycle * abc + temp);

    }

    private long lcm(long a, long b) {
        long min = Math.min(a, b);
        long max = Math.max(a, b);
        while (min > 0) {
            long temp = min;
            min = max % min;
            max = temp;
        }
        return a * (b/max);
    }

    private long min(long x, long y, long z) {
        return Math.min(x, Math.min(y, z));
    }
}
