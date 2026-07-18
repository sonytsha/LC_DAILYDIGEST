/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int count = 0;
        ListNode curr = head;
        while(curr!=null){
            // If current value is in the set, and it's the END of a connected segment
            if(set.contains(curr.val) &&(curr.next == null || !set.contains(curr.next.val))) count++;
            curr = curr.next;
        }
        return count;
    }
}