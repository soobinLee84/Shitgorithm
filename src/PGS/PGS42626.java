package PGS;

import java.util.PriorityQueue;

public class PGS42626 {

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>();
        // 우선순위 큐에 다 스코빌지수 모두 추가

        for (int s : scoville) {
            q.add(s);
        }

        while (q.size() > 1) {
            // k이상인지 확인
            if (q.peek() >= K) {
                return answer;
            }

            // 가장 안매운 스코빌지수 2개 추출
            // 스코빌지수 계산 후 저장
            q.add(q.poll() + (q.poll() * 2));
            answer++;
        }

        if (q.peek() < K) {
            return -1;
        }

        return answer;
    }

    public int solution2(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>();
        // 우선순위 큐에 다 스코빌지수 모두 추가

        for (int s : scoville) {
            q.add(s);
        }

        while (q.peek() < K) {
            // k이상인지 확인
            if (q.size() < 2) {
                return -1;
            }

            // 가장 안매운 스코빌지수 2개 추출
            // 스코빌지수 계산 후 저장
            q.add(q.poll() + (q.poll() * 2));
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        System.out.println(q.peek());
        //System.out.println(solution(new int[] {7}, 7));
    }
}
