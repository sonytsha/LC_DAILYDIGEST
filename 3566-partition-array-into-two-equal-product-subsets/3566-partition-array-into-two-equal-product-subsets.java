class Solution {
    public boolean checkEqualPartitions(int[] nums, long target) {
        ArrayList<ArrayList<Integer>> list1 = new ArrayList<>();
        ArrayList<Integer> s1 = new ArrayList<>();
        ArrayList<Integer> nums_copy = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            nums_copy.add(nums[i]);
        }
        recursion(nums_copy, target, list1, s1, 0, nums_copy.size() - 1, 1L);

        for (int i = 0; i < list1.size(); i++) {
            ArrayList<Integer> sublist = new ArrayList<>(list1.get(i));
            ArrayList<Integer> sublist2 = new ArrayList<>(nums_copy);

            for (int j = 0; j < sublist.size(); j++) {
                sublist2.remove(Integer.valueOf(sublist.get(j)));
            }

            if (sublist2.isEmpty()) continue;

            long prod = 1L;
            for (int j = 0; j < sublist2.size(); j++) { 
                prod *= sublist2.get(j);                 
            }

            if (prod == target) return true;
        }

        return false;
    }

    public boolean recursion(ArrayList<Integer> nums_copy, long target, ArrayList<ArrayList<Integer>> list1, ArrayList<Integer> s1, int start, int end, long prod1) {
        if (start > end) {
            if (prod1 == target && !s1.isEmpty()) {  
                list1.add(new ArrayList<>(s1));
                return true;
            }
            return false;
        }

        s1.add(nums_copy.get(start));

        boolean found1 = recursion(nums_copy, target, list1, s1, start + 1, end, prod1 * nums_copy.get(start));

        s1.remove(s1.size() - 1);

        boolean found2 = recursion(nums_copy, target, list1, s1, start + 1, end, prod1);

        return found1 || found2;  
    }
}
