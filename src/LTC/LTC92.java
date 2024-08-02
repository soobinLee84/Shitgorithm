package LTC;

public class LTC92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        int index = 1;
        ListNode rev = null;
        ListNode temp = new ListNode(-1, head);
        ListNode result = temp;
        ListNode end = null;

        while (temp.next != null) {
            if (index < left) {
                temp = temp.next;
            } else if (right < index) {
                break;
            } else {
                ListNode next = temp.next.next;
                temp.next.next = rev;
                rev = temp.next;
                temp.next = next;

                if (index == left) {
                    end = rev;
                }
            }

            index++;
        }

        end.next = temp.next;
        temp.next = rev;

        return result.next;
    }
}
