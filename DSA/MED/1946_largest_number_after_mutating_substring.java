class Solution {
    public String maximumNumber(String num, int[] change) {
        char[] arr = num.toCharArray();
        boolean started = false;

        for (int i = 0; i < arr.length; i++) {
            int d = arr[i] - '0';
            int mapped = change[d];

            if (!started) {
                if (mapped > d) {
                    arr[i] = (char) ('0' + mapped);
                    started = true;
                }
            } else {
                if (mapped >= d) {
                    arr[i] = (char) ('0' + mapped);
                } else {
                    break;
                }
            }
        }

        return new String(arr);
    }
}