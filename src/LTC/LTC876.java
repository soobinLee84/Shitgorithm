package LTC;

/**
 * 876. Middle of the Linked List
 */
public class LTC876 {

    public ListNode middleNode(ListNode head) {

        ListNode limit = head;
        ListNode answer = head;

        while (limit.next != null && limit.next.next != null) {
            limit = limit.next.next;
            answer = answer.next;
        }

        if (limit.next != null) {
            answer = answer.next;
        }

        return answer;
    }

    public ListNode middleNode2(ListNode head) {

        int index = 1;
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            index++;
        }

        index /= 2;
        node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
