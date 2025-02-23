class Solution {
    public double average(int[] salary) {
        int total = 0, min = salary[0], max = salary[0];
        for (int s : salary) {
            total += s;
            min = Math.min(s, min);
            max = Math.max(s, max);
        }
        return (0.0 + total - min - max)/(salary.length - 2);
    }
}
