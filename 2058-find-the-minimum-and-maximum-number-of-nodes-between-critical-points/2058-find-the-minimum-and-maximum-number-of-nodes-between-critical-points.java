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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
    if(head == null || head.next == null || head.next.next == null) return new int[]{-1,-1};
        int[] ans = new int[2];
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode nextNode = head.next.next;
        int count = 2;
        while(nextNode !=null){
            if(curr.val > prev.val && curr.val > nextNode.val){
                arr.add(count);
            }
            if(curr.val < prev.val && curr.val < nextNode.val){
                arr.add(count);
            }

            count++;
            prev = curr;
            curr = nextNode;
            nextNode = nextNode.next;
        }
        if(arr.size() < 2) return new int[]{-1,-1};

        int maxi = arr.get(arr.size() - 1) - arr.get(0);
        int mini = Integer.MAX_VALUE;

        for (int i = 1; i < arr.size(); i++) {
            mini = Math.min(mini, arr.get(i) - arr.get(i - 1));
        }

        ans[0] = mini;
        ans[1] = maxi;
        return ans;
    }
}