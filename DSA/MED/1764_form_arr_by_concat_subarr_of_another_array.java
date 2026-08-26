class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        int start = 0;

        for (int[] group : groups) {
            boolean found = false;

            while (start + group.length <= nums.length) {
                boolean match = true;

                for (int j = 0; j < group.length; j++) {
                    if (nums[start + j] != group[j]) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    start += group.length;
                    found = true;
                    break;
                }

                start++;
            }

            if (!found) {
                return false;
            }
        }

        return true;
    }
}