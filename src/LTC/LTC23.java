package LTC;

import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists
 */
public class LTC23 {
    public static ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);

        // 각 리스트의 맨앞 숫자를 우선순위큐에 추가
        for (ListNode node : lists) {
            if (node != null) {
                q.add(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;

        while (!q.isEmpty()) {
            // 우선순위 큐에서 가장 작은값 추출
            ListNode node = q.poll();
            dummy.next = node;

            // 추출한 값의 다음값 추가
            if (node.next != null) {
                q.add(node.next);
            }

            dummy = dummy.next;
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode[] a = new ListNode[]{new ListNode(1), new ListNode(2), new ListNode(3)};
        ListNode[] b = new ListNode[0];
        ListNode x = mergeKLists(b);

        while (x != null) {
            System.out.println(x.val);
            x = x.next;
        }
    }
}
