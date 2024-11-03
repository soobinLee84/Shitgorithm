package LTC;

public class LTC234 {

    /**
     * O(n) / O(1)
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }

        ListNode slow = head;  // 중간노드 탐색
        ListNode fast = head;  // 끝까지 탐색

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 중간부터 역순 정렬
        ListNode rev = null;
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = rev;
            rev = slow;
            slow = temp;
        }

        // 팰린드롬인지 확인
        while (rev != null) {
            if (rev.val != head.val) {
                return false;
            }

            rev = rev.next;
            head = head.next;
        }

        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        ListNode slow = head;  // 중간을 찾기위한 변수
        ListNode fast = head.next;  // 끝까지 탐색하는 변수

        // 1개
        if (fast == null) {
            return true;
        }

        // 2개
        if (fast.next == null) {
            return head.val == fast.val;
        }
        fast = fast.next;

        // 중간찾기
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next.next;

        // 중간 이후 리스트로 역순 리스트 만들기
        ListNode rev = null;
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = rev;
            rev = slow;
            slow = temp;
        }

        // 중간 이전과 중간 이후 비교하기
        while (rev != null) {
            if (rev.val != head.val) {
                return false;
            }

            rev = rev.next;
            head = head.next;
        }

        return true;

    }
}
