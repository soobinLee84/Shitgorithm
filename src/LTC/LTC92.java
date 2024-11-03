package LTC;

public class LTC92 {

    /**
     * O(n) / O(1)
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {

        int index = 1;
        ListNode temp = new ListNode(-1, head);
        ListNode result = temp;
        ListNode rev = null;
        ListNode revEnd = null;

        while (temp.next != null) {
            if (index < left) {
                temp = temp.next;
            } else if (index > right) {
                break;
            } else {
                ListNode next = temp.next.next;
                temp.next.next = rev;
                rev = temp.next;
                temp.next = next;

                if (index == left) {  // rev 마지막
                    revEnd = rev;
                }
            }

            index++;
        }

        revEnd.next = temp.next;
        temp.next = rev;

        return result.next;
    }
}
