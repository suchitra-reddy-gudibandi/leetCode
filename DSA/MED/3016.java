class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];

        for(char c:word.toCharArray())
            freq[c-'a']++;

        Arrays.sort(freq);

        int pushes=0;

        for(int i=25,pos=0;i>=0&&freq[i]>0;i--,pos++){
            pushes += freq[i]*(pos/8+1);
        }
        return pushes;
    }
}