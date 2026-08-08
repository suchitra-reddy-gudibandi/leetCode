class Solution {
    public int[] validSequence(String word1, String word2) {
        int n= word1.length();
        int m=word2.length();

        int[] last=new int[m];

        int i=n-1,j=m-1;
        while(i>=0&& j>=0){
            if(word1.charAt(i)==word2.charAt(j)){
                last[j--]=i;
            }
            i--;
        }
        int[] ans=new int[m];
        j=0;
        boolean changed = false;

        for(i=0;i<n&&j<m;i++){
            if(word1.charAt(i)==word2.charAt(j)){
                ans[j++]=i;
            }
            else if(!changed && (j==m-1 || i<last[j+1])){
                ans[j++]=i;
                changed=true;
            }
        }
        return j==m?ans:new int[0];
    }
}