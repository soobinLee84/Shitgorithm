package LTC;

public class LTC147 {

    public ListNode insertionSortList(ListNode head) {

        // 정렬된
        ListNode result = new ListNode();
        ListNode cur = result;

        while (head != null) {

            while (cur.next != null && cur.next.val < head.val) {
                cur = cur.next;
            }

            ListNode headNext = head.next;
            head.next = cur.next;
            cur.next = head;

            head = headNext;
            if (head != null && cur.val > head.val)
                cur = result;
        }

        return result.next;

    }

    public ListNode insertionSortList2(ListNode head) {

        ListNode result = new ListNode();

        while (head != null) {
            sort(result, head);
            head = head.next;
        }

        return result.next;
    }

    private void sort(ListNode list, ListNode item) {

        ListNode pre = list;
        ListNode cur = list.next;

        while (cur != null) {
            if (cur.val > item.val) {
                break;
            }

            pre = pre.next;
            cur = cur.next;
        }

        pre.next = new ListNode(item.val, cur);

    }
}
