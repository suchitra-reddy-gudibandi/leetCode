class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int x:nums){
            set.add(x);
            min=Math.min(min,x);
            max=Math.max(max,x);
        }
        List<Integer>ans=new ArrayList<>();
        for(int i=min;i<=max;i++)
            if(!set.contains(i)) ans.add(i);
        
        return ans;
    }
}