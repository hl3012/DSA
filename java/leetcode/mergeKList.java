import java.util.PriorityQueue;

public class mergeKList {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        for (ListNode l: lists) {
            if(l!=null) pq.offer(l);
        }
        while (!pq.isEmpty()) {
            ListNode n=pq.poll();
            curr.next=n;
            curr=curr.next;

            if (n.next!=null) {
                pq.offer(n.next);
            }
        }
        return dummy.next;
    }
}
