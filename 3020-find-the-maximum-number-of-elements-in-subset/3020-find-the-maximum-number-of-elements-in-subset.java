class Solution {
    public int maximumLength(int[] nums) {

        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean dual = false;

        for (int i = 0; i < len; i++) {

            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
                dual = true;
            } else {
                map.put(nums[i], 1);
            }
        }

        if (dual == false) {
            return 1;
        }

        int ans = 1;

        if (map.containsKey(1)) {
            int count = map.get(1);

            if (count % 2 == 0) {
                ans = Math.max(ans, count - 1);
            } else {
                ans = Math.max(ans, count);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int curr = entry.getKey();

            if (curr == 1) {
                continue;
            }

            int currLen = 0;

            while (map.containsKey(curr) && map.get(curr) >= 2) {
                currLen += 2;
                curr = curr * curr;
            }

            if (map.containsKey(curr)) {
                currLen++;
            } else {
                currLen--;
            }

            ans = Math.max(ans, currLen);
        }

        return ans;
    }
}