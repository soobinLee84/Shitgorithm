package LTC;

/**
 * 21. Merge Two Sorted Lists
 */
public class LTC21 {

    /**
     * 재귀<br>
     * O(n+m) / O(n+m)
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists2(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists2(list1, list2.next);
            return list2;
        }

    }

    /**
     * 반복문<br>
     * O(n+m) / O(1)
     * @param list1
     * @param list2
     * @return
     */
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

        ListNode list = new ListNode(-1);
        ListNode result = list;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                list.next = new ListNode(list2.val);
                list2 = list2.next;
            }

            list = list.next;
        }

        if (list1 == null) {
            list.next = list2;
        }

        if (list2 == null) {
            list.next = list1;
        }

        return result.next;
    }


}
