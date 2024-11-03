package LTC;

public class LTC328 {

    /**
     * O(n) / O(1)
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenFirst = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenFirst;
        return head;

    }

    public ListNode oddEvenList2(ListNode head) {
        ListNode odd = new ListNode(-1, head);
        ListNode result = odd;
        ListNode even = new ListNode(-1);
        ListNode firstEven = even;
        int index = 1;

        while (odd.next != null) {
            if (index % 2 == 0) {  // 짝수번째
                even.next = odd.next;
                odd.next = odd.next.next;
                even.next.next = null;
                even = even.next;

            } else {
                odd = odd.next;
            }

            index++;
        }

        odd.next = firstEven.next;

        return result.next;

    }
}
