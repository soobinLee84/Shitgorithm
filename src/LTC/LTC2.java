package LTC;

public class LTC2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int v, r = 0;
        ListNode temp = new ListNode(-1);
        ListNode result = temp;

        while (l1 != null || l2 != null) {
            v = r;
            if (l1 != null) {
                v += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                v += l2.val;
                l2 = l2.next;
            }

            temp.next = new ListNode(v % 10);
            r = v / 10;

            temp = temp.next;
        }

        if (r > 0) {
            temp.next = new ListNode(r);
        }

        return result.next;
    }
}
