/*链表结点的定义(请不要在代码中定义该类型)
public class ListNode {
  public int val;
  public ListNode next;
}*/
import java.util.*;
public class MergeKSortedList {
    // lists包含k个链表头结点,返回合并后链表头结点
    public ListNode merge(List<ListNode> lists) {
        if(lists == null || lists.size() == 0) return null;
        while(lists.size() > 1) {
            for(int i = 0; i < lists.size() - 1; i += 2) {
                //merge 2 lists    
                ListNode dummy = new ListNode(1 << 31);
                ListNode curr = dummy;
                ListNode a = lists.get(i);
                ListNode b = lists.get(i + 1);
                while (a != null && b != null) {
                    if(a.val <= b.val) {
                        curr.next = a;
                        a = a.next;
                        curr = curr.next;
                    } else {
                        curr.next = b;
                        b = b.next;
                        curr = curr.next;
                    }
                }
                if(a != null) {
                    curr.next = a;
                }
                else if(b != null) {
                    curr.next = b;
                }
                lists.set(i, dummy.next);
                lists.set(i + 1, null);
            }
            List<ListNode> newLists = new LinkedList<ListNode>();
            for(ListNode l : lists) {
                if(l != null) {
                    newLists.add(l);
                }
            }
            lists = newLists;
        }
        return lists.get(0);
    }
}
