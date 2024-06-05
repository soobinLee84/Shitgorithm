package PGS;

public class PGS42862 {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int[] clothes = new int[n + 2];

        for (int l : lost) {
            clothes[l]--;
        }

        for (int r : reserve) {
            clothes[r]++;
        }

        for (int i = 1; i < clothes.length; i++) {
            if (clothes[i] == 1) {
                if (clothes[i - 1] == -1) {
                    clothes[i] = 0;
                    clothes[i - 1] = 0;
                } else if (clothes[i + 1] == -1) {
                    clothes[i] = 0;
                    clothes[i + 1] = 0;
                }
            }
        }

        int answer = 0;
        for (int c : clothes) {
            if (c > -1) {
                answer++;
            }
        }

        return answer - 2;
    }
}
