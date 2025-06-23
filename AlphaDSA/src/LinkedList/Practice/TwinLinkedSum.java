package LinkedList.Practice;

public class TwinLinkedSum {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int data) {
            this.val = data;
        }
    }
    public int pairSum(ListNode head){
        ListNode l1=head;
        ListNode l2=midPoint(head).next;
        l2=reverseList(l2);
        int result=Integer.MIN_VALUE;
        while (l1!=null && l2!=null){
            result=Math.max(result,(l1.val+l2.val));
            l2=l2.next;
            l1=l1.next;
        }
        return result;
    }

    public ListNode midPoint(ListNode head){
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode curr = head, prev = null, nxt = null;
        while (curr != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
}
