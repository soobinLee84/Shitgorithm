package LTC;

public class LTC206 {

    /**
     * O(n) / O(1)
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode rev = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = rev;
            rev = head;
            head = temp;
        }

        return rev;
    }
}