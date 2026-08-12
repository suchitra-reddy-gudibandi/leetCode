class Solution {
    public int partitionString(String s) {
        boolean[] seen = new boolean[26];
        int partitions=1;

        for(int i=0;i<s.length();i++){
            int index = s.charAt(i)-'a';

            if(seen[index]){
                partitions++;
                seen=new boolean[26];
            }
            seen[index]=true;
        }
        return partitions;
    }
}