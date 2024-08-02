package LTC;

public class LTC206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;

        ListNode rev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = rev;
            rev = head;
            head = next;
        }

        return rev;
    }
}