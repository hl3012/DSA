class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val=val;
        this.next=null;
    }
}

class ReverseLinkedList {
    public static ListNode reverseList (ListNode node) {
        // ListNode pre = null;
        // ListNode curr = node;
        // while (curr!=null) {
        //     ListNode next = curr.next;
        //     curr.next=pre;
        //     pre=curr;
        //     curr=next;
        // }
        // return pre;

        // if (node==null) return null;
        if (node.next==null) return node;
        ListNode curr = node;
        ListNode left = reverseList(curr.next);
        curr.next.next=null;
        curr.next=null;
        return left;
    } 

}

