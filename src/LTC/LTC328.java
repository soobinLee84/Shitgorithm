package LTC;

public class LTC328 {
    public ListNode oddEvenList(ListNode head) {
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
