package LTC;

/**
 * 21. Merge Two Sorted Lists
 */
public class LTC21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode a = list1;
        ListNode b = list2;
        ListNode list = null;

        if (a.val < b.val) {
            list = new ListNode(a.val);
            a = a.next;
        } else {
            list = new ListNode(b.val);
            b = b.next;
        }

        ListNode result = list;

        while (a != null && b != null) {
            if (a.val < b.val) {
                list.next = new ListNode(a.val);
                a = a.next;
            } else {
                list.next = new ListNode(b.val);
                b = b.next;
            }

            list = list.next;
        }

        if (a == null) {
            list.next = b;
        }

        if (b == null) {
            list.next = a;
        }

        return result;
    }

    public class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
