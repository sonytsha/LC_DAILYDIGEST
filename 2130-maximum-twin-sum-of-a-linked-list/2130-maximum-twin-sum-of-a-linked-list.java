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
    public int pairSum(ListNode head) {
        ListNode curr = head;
        int len = length(curr);
        curr = head;
        int[] arr = new int[len];
        int i=0;
        while(curr!=null){
            arr[i] = curr.val;
            curr = curr.next;
            i++;
        }
        int maxi = 0;
        for(int j=0;j<len/2;j++){
            int sum = arr[j] + arr[len-1-j];
            maxi = Math.max(maxi, sum);
        }
        return maxi;
    }
    public int length(ListNode head){
        int count = 0;
        while(head!= null){
            count++;
            head = head.next;
        }
        return count;
    }
}


/* 

class Solution {
    public int pairSum(ListNode head) {
        ListNode curr = head;
        int len = length(curr);
        curr = head;
        int[][] arr = new int[len][2];
        int i = 0;
        while(curr!=null){
            arr[i][0] = i;
            arr[i][1] = curr.val;
            curr = curr.next;
            i++;
        }
        int maxi = 0;
        for(int j=0;j<len/2;j++){
            int sum = arr[j][1] + arr[len-1-j][1];
            maxi = Math.max(maxi, sum);
        }
        return maxi;
    }
    public int length(ListNode head){
        int count = 0;
        while(head!= null){
            count++;
            head = head.next;
        }
        return count;
    }
} 

*/

 /*
class Solution {
    public int pairSum(ListNode head) {
        ListNode current = head;
        int len = length(current);
        current = head;

        int maxi = 0;
        int pos = 0;
        for(int i=0;i<len/2;i++){
            
            int sum = current.val + find(head, pos, len).val;
            maxi = Math.max(maxi, sum);
            current = current.next;
            pos++;
        }
        return maxi;
    }

    public ListNode find(ListNode curr1, int pos, int len){
        int findPos = (len-1-pos);
        int count = 0;
        while(count!= findPos){
            curr1 = curr1.next;
            count++;
        }
        return curr1;
    }
    public int length(ListNode head){
        int count = 0;
        while(head!= null){
            count++;
            head = head.next;
        }
        return count;
    }
}

*/