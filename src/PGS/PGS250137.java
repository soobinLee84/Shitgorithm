package PGS;

public class PGS250137 {
    public static void main(String[] args) {
//        System.out.println(solution(new int[]{5, 1, 5}, 30, new int[][]{{2, 10}, {9, 15}, {10, 5}, {11, 5}}));
        System.out.println(solution(new int[]{10, 10, 100}, 10, new int[][]{{1, 15}, {3, 1}}));

    }

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int lastTime = attacks[attacks.length - 1][0];

        int ai = 0;  //attacks index
        int bi = 0;  //bondage index
        for (int i = 1; i <= lastTime; i++) {
            if (i == attacks[ai][0]) {
                health -= attacks[ai][1];
                ai++;
                bi = 0;

                if (health < 1) return -1;
            } else {
                health += bandage[1];
                bi++;

                if (bi == bandage[0]) {
                    health += bandage[2];
                    bi = 0;
                }

                if (health > maxHealth) {
                    health = maxHealth;
                }
            }

        }

        return health;
    }
}
