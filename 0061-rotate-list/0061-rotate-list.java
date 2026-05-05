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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode curr = head;
        int len = length(curr);
        if(len==0) return null;
        /* gay error : java.lang.ArithmeticException: / by zero
        at line 15, Solution.rotateRight
        at line 56, __DriverSolution__.__helper__
        at line 89, __Driver__.main
        */
        k = k%len;
        if(k==0) return head;
        /* gay wrongness :
        Input
        head =
        [1,2]
        k =
        0

        Use Testcase
        Stdout
        k is : 0
        curr moving : 2
        ans is standing at : 2
        len is : 2
        len is : 1
        ans is standing post full len traversal : 1
        Output
        [2,1]
        Expected
        [1,2]
        */
        System.out.println("k is : " + k);
        ListNode newNode = new ListNode(0);
        ListNode ans = newNode;
        curr = head;
        int point = 0;
        while(point != len-k){
            curr = curr.next;
            point++;
        }
        
       System.out.println("curr is standing at : " + curr.val);

        while(curr != null){
            System.out.println("curr moving : "+ curr.val);
            newNode.next = new ListNode(curr.val);
            curr = curr.next;
            newNode = newNode.next;
            point++;
          //  System.out.println("newNode forming : " + newNode.val);
        }
        
        /*
        System.out.println("newNode is : ");
        while(ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
        */

        newNode.next = head;
        ans = ans.next;
        System.out.println("ans is standing at : " + ans.val);    
        ListNode somethingSomething = ans;    
        System.out.println("len is : " + len);
        while(len-1!=0 && ans!= null){
            ans = ans.next;
            len--;
        }
        System.out.println("len is : " + len);
        System.out.println("ans is standing post full len traversal : " + ans.val); 
        ans.next = null;
        return somethingSomething;
    }
    public int length(ListNode curr){
        int len = 0;
        while(curr!= null){
            len++;
            curr = curr.next;
        }
        return len;
    }
}