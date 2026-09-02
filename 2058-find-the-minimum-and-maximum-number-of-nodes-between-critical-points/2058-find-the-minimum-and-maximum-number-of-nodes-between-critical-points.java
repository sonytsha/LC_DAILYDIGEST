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
        int[] ans = new int[2];

        if(head == null || head.next == null || head.next.next == null){
            ans[0] = -1; ans[1] = -1;
            return ans;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode nextNode = head.next.next;
        ListNode curr = head.next;
        ListNode prev = head;
        int i = 3;
        while(nextNode!= null){
            if(nextNode.val > curr.val && prev.val > curr.val){
                arr.add(i);
            }
            if(nextNode.val < curr.val && prev.val < curr.val){
                arr.add(i);
            }
            nextNode = nextNode.next;
            curr = curr.next;
            prev = prev.next;
            i++;
        }
        Collections.sort(arr);
        if (arr.size() < 2) { 
            ans[0] = -1; ans[1] = -1; 
            return ans; 
            }
        int localMini = Integer.MAX_VALUE;
        for(int k=1;k<arr.size();k++){
            localMini  = Math.min(localMini , arr.get(k) - arr.get(k - 1));
        }
        int localMaxi = arr.get(arr.size() - 1) - arr.get(0);
        ans[0] = localMini;
        ans[1] = localMaxi;
        return ans;
    }
}