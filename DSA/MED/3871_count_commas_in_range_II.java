class Solution {
    public long countCommas(long n) {
        long ans = 0;
        long start = 1000;

        while (start <= n) {
            long end = Math.min(n, start * 1000 - 1);
            ans += (end - start + 1) * ((long)Math.log10(start) / 3);
            start *= 1000;
        }

        return ans;
    }
}