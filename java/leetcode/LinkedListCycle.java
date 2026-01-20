import java.util.*;
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode curr= head;
        while (curr!=null) {
            if (visited.contains(curr)) {
                return true;
            }
            visited.add(curr);
            curr=curr.next;
        }
        return false;
    }
}
