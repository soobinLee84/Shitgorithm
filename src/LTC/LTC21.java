package LTC;

/**
 * 21. Merge Two Sorted Lists
 */
public class LTC21 {

    // 재귀
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }

    }

    // 반복문
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // 리스트가 비어있을 경우
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
        ListNode list = new ListNode(-1);
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

        return result.next;
    }


}
