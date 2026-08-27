class Solution {
    TreeMap<Integer, Integer> low = new TreeMap<>();
    TreeMap<Integer, Integer> high = new TreeMap<>();
    int lowSize = 0, highSize = 0;

    void add(int x) {
        if (low.isEmpty() || x <= low.lastKey()) {
            low.put(x, low.getOrDefault(x, 0) + 1);
            lowSize++;
        } else {
            high.put(x, high.getOrDefault(x, 0) + 1);
            highSize++;
        }
        balance();
    }

    void remove(int x) {
        if (low.containsKey(x)) {
            removeFrom(low, x);
            lowSize--;
        } else {
            removeFrom(high, x);
            highSize--;
        }
        balance();
    }

    void removeFrom(TreeMap<Integer, Integer> map, int x) {
        int count = map.get(x);
        if (count == 1) {
            map.remove(x);
        } else {
            map.put(x, count - 1);
        }
    }

    void balance() {
        while (lowSize > highSize + 1) {
            int x = low.lastKey();
            removeFrom(low, x);
            lowSize--;
            high.put(x, high.getOrDefault(x, 0) + 1);
            highSize++;
        }

        while (lowSize < highSize) {
            int x = high.firstKey();
            removeFrom(high, x);
            highSize--;
            low.put(x, low.getOrDefault(x, 0) + 1);
            lowSize++;
        }
    }

    double getMedian() {
        if (lowSize > highSize) {
            return (double) low.lastKey();
        }

        return ((double) low.lastKey() + (double) high.firstKey()) / 2.0;
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] ans = new double[n - k + 1];

        for (int i = 0; i < k; i++) {
            add(nums[i]);
        }

        ans[0] = getMedian();

        for (int i = k; i < n; i++) {
            remove(nums[i - k]);
            add(nums[i]);
            ans[i - k + 1] = getMedian();
        }
        return ans;
    }
}