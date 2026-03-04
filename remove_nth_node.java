
class remove_nth_node {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Dummy node helps handle cases like removing the head node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // 1. Move fast pointer so there's a gap of n nodes between slow and fast
        // We move it n + 1 times so slow ends up right BEFORE the target node
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // 2. Move both pointers until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // 3. Skip the nth node
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}
