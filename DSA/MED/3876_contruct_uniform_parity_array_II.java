class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;
        
        for (int num : nums1) {
            if (num % 2 == 0) {
                minEven = Math.min(minEven, num);
            } else {
                minOdd = Math.min(minOdd, num);
            }
        }
        
        // True if array has only evens or only odds
        if (minOdd == Integer.MAX_VALUE || minEven == Integer.MAX_VALUE) {
            return true;
        }
        
        // True if the smallest odd can reduce all even numbers
        return minOdd < minEven;
    }
}