package LTC;

import java.util.ArrayList;
import java.util.List;

/**
 * 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points
 */

public class LTC2058 {

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> critical = new ArrayList<>();

        ListNode beforeNode = head;
        ListNode target = head.next;
        int index = 2;

        int minDistance = Integer.MAX_VALUE;
        int beforeIndex = 0;

        while (target != null && target.next != null) {

            if ((beforeNode.val < target.val && target.next.val < target.val)
                || (beforeNode.val > target.val && target.next.val > target.val)) {  // 앞뒤 노드의 값보다 작을 때 / 클 때
                critical.add(index);

                if (beforeIndex != 0) {  // 인덱스의 거리차이
                    minDistance = Math.min(minDistance, index - beforeIndex);
                }
                beforeIndex = index;
            }
            index++;
            beforeNode = target;
            target = target.next;
        }

        if (critical.size() < 2) {
            return new int[]{-1, -1};
        }

        return new int[]{minDistance, (critical.get(critical.size() - 1) - critical.get(0))};
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
