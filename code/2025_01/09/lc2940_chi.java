import java.util.Comparator;
import java.util.Arrays;
class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int[][] sort = new int[queries.length][3];
        for (int i = 0; i < queries.length; i++) {
            sort[i][0] = Math.max(queries[i][0], queries[i][1]);
            sort[i][1] = Math.min(queries[i][1], queries[i][0]);
            sort[i][2] = i;
        }
        Arrays.sort(sort, Comparator.comparingInt(a -> -a[0]));
        int[][] q = new int[heights.length][2];
        int p = 0, prev = heights.length;
        int[] ans = new int[queries.length];
        for (int i = 0; i < sort.length; i++) {
            int a = sort[i][0], b = sort[i][1];
            while (prev > a) {
                prev--;
                while (p > 0 && q[p - 1][0] <= heights[prev]) p--;
                q[p][0] = heights[prev];
                q[p][1] = prev;
                p++;
            }

            if (a == b || heights[b] < heights[a]) {
                ans[sort[i][2]] = a;
                continue;
            }
            int left = 0, right = p - 1, res = -1;
            while (left <= right) {
                int mid = (left + right)/2;
                if (q[mid][0] > heights[b]) {
                    res = q[mid][1];
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            ans[sort[i][2]] = res;
        }
        return ans;
    }
}