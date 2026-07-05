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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if(head == null || head.next == null) return head;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int count = 1;
        while(head!=null){
            ArrayList<Integer> subarr = new ArrayList<>();
            for(int i=0;i<count && head != null;i++){
                subarr.add(head.val);
                head = head.next;
            }
            arr.add(subarr);
            count++;
        }
        for(int i=0;i<arr.size();i++){
            ArrayList<Integer> subarr = arr.get(i);
            if(subarr.size() % 2 == 0){
                Collections.reverse(subarr);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;
        for(int i=0;i<arr.size();i++){
            ArrayList<Integer> subarr = arr.get(i);
            for(int j=0;j<subarr.size();j++){
                dummy.next = new ListNode(subarr.get(j));
                dummy = dummy.next;
            }
        }
        return ans.next;
    }
}