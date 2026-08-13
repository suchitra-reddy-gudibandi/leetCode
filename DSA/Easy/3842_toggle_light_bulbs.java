class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        boolean[] on=new boolean[101];

        for(int bulb:bulbs){
            on[bulb]=!on[bulb];
        }
        List<Integer>ans=new ArrayList<>();

        for(int i=1;i<=100;i++){
            if(on[i]){
                ans.add(i);
            }
        }
        return ans;
    }
}