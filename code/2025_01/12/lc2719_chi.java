class Solution {
    private int mod = 1000000007;
    public int count(String num1, String num2, int min_sum, int max_sum) {
        int n = num2.length();
        int len1 = num1.length();
        int[] digit1 = new int[n];
        int[] digit2 = new int[n];
        for (int i = 0; i < n; i++) {
            digit2[i] = num2.charAt(n - 1 - i) - '0';
            if (i < len1) digit1[i] = num1.charAt(len1 - 1 - i) - '0';
        }
        max_sum = Math.min(max_sum, 9 *n);
        if (max_sum < min_sum) return 0;
        while (n > 0 && digit1[n -1] == digit2[n-1]) {
            min_sum -= digit1[n-1];
            max_sum -= digit1[n-1];
            n--;
        }
        System.out.println(n);
        if (max_sum < 0) return 0;
        min_sum = Math.max(0, min_sum);
        if (n == 0) return min_sum == 0 ? 1 : 0;
        if (n == 1) {
            int min = Math.max(digit1[0], min_sum);
            int max = Math.min(digit2[0], max_sum);
            return Math.max(0, max - min + 1);
        }
        //count[i][j][0]: number of integers with i + 1 digits and total of digits is j
        //count[i][j][1]: number of integers with i + 1 digits and total of digits is j, and larger than the last i digits of num1
        //count[i][j][2]: number of integers with i + 1 digits and total of digits is j, and smaller than the last i digits of num2
        int[][][] count = new int[n][max_sum + 1][3];
        for (int i = 0; i <= Math.min(9, max_sum); i++) {
            count[0][i][0] = 1;
            if (i >= digit1[0]) count[0][i][1] = 1;
            if (i <= digit2[0]) count[0][i][2] = 1;
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j <= max_sum; j++) {
                //all
                int temp = 0;
                for (int k = 0; k <= Math.min(9, j); k++) temp = add(temp, count[i-1][j - k][0]);
                count[i][j][0] = temp;
                //larger than num1
                temp = (j >= digit1[i]) ? count[i -1][j - digit1[i]][1] : 0;
                for (int k = digit1[i] + 1; k <= Math.min(9, j); k++) temp = add(temp, count[i-1][j - k][0]);
                count[i][j][1] = temp;
                //smaller than num2
                temp = (j >= digit2[i]) ? count[i -1][j - digit2[i]][2] : 0;
                for (int k = 0; k <= Math.min(digit2[i] - 1, j); k++) temp = add(temp, count[i-1][j - k][0]);
                count[i][j][2] = temp;
            }
        }
        int ans = 0;
        for (int i = Math.max(0, min_sum - digit1[n -1]); i <= max_sum - digit1[n - 1]; i++) ans = add(ans, count[n-2][i][1]);
        for (int i = Math.max(0, min_sum - digit2[n - 1]); i <= max_sum - digit2[n -1]; i++) ans = add(ans, count[n-2][i][2]);
        for (int i = digit1[n-1] + 1; i <= digit2[n - 1] - 1; i++) {
            for (int j = Math.max(0, min_sum - i); j <= max_sum - i; j++) ans = add(ans, count[n - 2][j][0]);
        }
        return ans;
    }

    private int add(int a, int b) {
        return (a + b) % mod;
    }
}
