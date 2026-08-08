class Solution {
    public int strangePrinter(String s) {
        StringBuilder t=new StringBuilder();
        for(char c:s.toCharArray()){
            if(t.length()==0 || t.charAt(t.length()-1)!=c)
                t.append(c);
        }
        s=t.toString();
        int n=s.length();

        int[][] dp=new int[n][n];

        for(int i=0;i<n;i++)
           dp[i][i]=1;
        
        for(int len=2;len<=n;len++){
            for(int i=0;i+len <= n;i++){
                int j=i+len-1;

                dp[i][j]=dp[i+1][j]+1;

                for(int k=i+1;k<=j;k++){
                    if(s.charAt(i)==s.charAt(k)){
                        int left = (k==i+1)?0:dp[i+1][k-1];
                        dp[i][j]=Math.min(dp[i][j],left+dp[k][j]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}