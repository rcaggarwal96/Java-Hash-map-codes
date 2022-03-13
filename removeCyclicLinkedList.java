/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(slow==null){
            return null;
        }
        if(slow.next==null || fast.next==null){
            return null;
        }
        if(slow.next!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next;   
        }
        if(fast.next!=null){
            fast = fast.next;   
        }else{
            return null;
        }
        while(slow!=fast){
            if(slow.next!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next;   
            }
            else{
                return null;
            }
            if(fast.next!=null){
                fast = fast.next;   
            }
            else{
                return null;
            }
        }
        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        /*while(fast.next!=slow){
            fast=fast.next;
        }
        fast.next=null;*/
        return slow;
    }
}
