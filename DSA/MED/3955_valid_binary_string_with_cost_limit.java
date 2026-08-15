class Solution {
    public List<String> generateValidStrings(int n, int k) {
        int[] lavomirex = {n, k};
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        dfs(0, 0, false, lavomirex[0], lavomirex[1], sb, ans);

        return ans;
    }

    private void dfs(int i, int cost, boolean prevOne, int n, int k,
                     StringBuilder sb, List<String> ans) {
        if (i == n) {
            ans.add(sb.toString());
            return;
        }

        sb.append('0');
        dfs(i + 1, cost, false, n, k, sb, ans);
        sb.deleteCharAt(sb.length() - 1);

        if (!prevOne && cost + i <= k) {
            sb.append('1');
            dfs(i + 1, cost + i, true, n, k, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}