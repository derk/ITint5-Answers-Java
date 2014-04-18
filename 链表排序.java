public class LinkListSort {
    public ListNode sort(ListNode head) {
        int len = 0;
        ListNode curr = head;
        while(curr != null) {
            curr = curr.next;
            len++;
        }
        if(len <= 1) {
            return head;
        }
        int mid = len >>> 1;
        curr = head;
        while(mid-- > 1) {
            curr = curr.next;
        }
        ListNode l = head;
        ListNode r = curr.next;
        curr.next = null;
        l = sort(l);
        r = sort(r);
        ListNode dummy = new ListNode();
        curr = dummy;
        while(l != null && r != null) {
            if(l.val < r.val) {
                curr.next = l;
                l = l.next;
                curr = curr.next;
            } else {
                curr.next = r;
                r = r.next;
                curr = curr.next;
            }
        }
        while(l != null) {
            curr.next = l;
            l = l.next;
            curr = curr.next;
        }
        while(r != null) {
            curr.next = r;
            r = r.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
