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
    public ListNode oddEvenList(ListNode head) {
        ListNode evenStart = null;
        ListNode evenEnd = null;
        ListNode oddStart = null;
        ListNode oddEnd = null;
        ListNode currentNode = head;
        while(currentNode!=null){
            int element = currentNode.val;
            if(element%2==0){
                if(evenStart==null){
                    evenStart = currentNode;
                    evenEnd = evenStart;
                }
                else{
                    evenEnd.next = currentNode;
                    evenEnd = evenEnd.next;
                }
            }
            else{
                if(oddStart==null){
                    oddStart = currentNode;
                    oddEnd = currentNode;
                }
                else{
                    oddEnd.next = currentNode;
                    oddEnd = oddEnd.next;
                }
            }
            currentNode = currentNode.next;
        }
        if(oddStart!=null && evenStart!=null){
            oddEnd.next = evenStart;
            evenEnd.next = null;
            head = oddStart;
        }else{
            if(oddStart==null && evenStart!=null){
                evenEnd = null;
                head = evenStart;
            }
            else{
                if(oddStart!=null && evenStart==null){
                    oddEnd = null;
                    head = oddStart;
                }
                else{
                    if(head==null && oddStart==null && evenStart==null){
                        return head;
                    }
                }
            }
        }
        
        return head;
    }
}
