/**
 * 
 * https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
 * https://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list/
 * reverse a singly/doubly linked list
 * 
 * A : [ 159 -> 949 -> 928 -> 101 -> 409 -> 678 -> 448 ]
 * 
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode solve(ListNode A) {
        ListNode slow=A;
        ListNode fast = A;
        if(A==null){
            return A;
        }
        //if(slow.next==fast.next && slow.next==null){
        if(slow.next==null){
            A=null;
            return A;
        }
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast = fast.next;
            fast = fast.next;
        }
        if(fast.next!=null){
            slow = slow.next;
        }
        ListNode middle = A;
        while(middle.next!=slow){
            middle = middle.next;
        }
        //slow = slow.next;
        middle.next=slow.next;
        slow.next=null;
        return A;
    }
}
