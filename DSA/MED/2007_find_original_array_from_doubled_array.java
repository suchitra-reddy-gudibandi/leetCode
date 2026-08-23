class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;

        if (n % 2 != 0) {
            return new int[0];
        }

        Arrays.sort(changed);

        Map<Integer, Integer> map = new HashMap<>();

        for (int x : changed) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int[] original = new int[n / 2];
        int idx = 0;

        for (int x : changed) {
            if (map.get(x) == 0) {
                continue;
            }

            if (x == 0) {
                if (map.get(x) < 2) {
                    return new int[0];
                }

                map.put(x, map.get(x) - 2);
                original[idx++] = 0;
            } else {
                int doubled = x * 2;

                if (map.getOrDefault(doubled, 0) == 0) {
                    return new int[0];
                }

                map.put(x, map.get(x) - 1);
                map.put(doubled, map.get(doubled) - 1);

                original[idx++] = x;
            }
        }

        return original;
    }
}