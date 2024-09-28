package LTC;

public class LTC148 {

    // 쪼개고
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode faster = head;
        ListNode slow = head;

        while (faster.next != null && faster.next.next != null) {
            faster = faster.next.next;
            slow = slow.next;
        }

        ListNode r = sortList(slow.next);
        slow.next = null;
        ListNode l = sortList(head);

        return mergeList(l, r);

    }

    private ListNode mergeList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeList(l1, l2.next);
            return l2;
        }

    }
}
