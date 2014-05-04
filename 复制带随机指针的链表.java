/**
链表结点的定义(请不要在代码中定义该类型)
public class ListNode {
   public ListNode next;
   public ListNode random;
};
*/
public class CopyListWithRandomPtr {
    public ListNode copyListWithRandomPtr(ListNode head) {
        if(head == null) return null;
        ListNode curr = head;
        while(curr!=null) {
            ListNode newNode = new ListNode();
            ListNode oldNext = curr.next;
            curr.next = newNode;
            newNode.next = oldNext;
            curr = oldNext;
        }
        curr = head;
        while(curr!=null && curr.next!=null) {
            curr.next.random=curr.random.next;
            curr=curr.next.next;
        }
        ListNode dummyOrig = new ListNode();
        ListNode dummyNew = new ListNode();
        ListNode currOrig = dummyOrig;
        ListNode currNew = dummyNew;
        curr = head;
        boolean isOrig = true;
        while(curr!=null){
            if(isOrig){
                currOrig.next = curr;
                currOrig = currOrig.next;
            } else {
                currNew.next = curr;
                currNew = currNew.next;
            }
            curr = curr.next;
            isOrig = !isOrig;
        }
        head = dummyOrig.next;
        return dummyNew.next;
    }
}
