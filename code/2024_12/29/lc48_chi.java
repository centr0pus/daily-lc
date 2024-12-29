class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int temp;
        for (int i = 0; i < n/2; i++) {
            //rotate from i to n-1-i;
            for (int j = 0; j < n-2*i - 1; j++) {
                
                temp = matrix[i][n-1-i-j];
                // System.out.println(temp);
                matrix[i][n-1-i-j] = matrix[i+j][i]; 
                matrix[i+j][i] = matrix[n-1-i][i+j];
                matrix[n-1-i][i+j] = matrix[n-1-i-j][n-1-i];
                matrix[n-1-i-j][n-1-i] = temp;
            }
        }
    }
}
