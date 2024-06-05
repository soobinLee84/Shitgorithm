package PGS;

import java.util.HashMap;
import java.util.Map;

public class PGS178871 {
    public static void main(String[] args) {

    }

    public static String[] solution(String[] players, String[] callings) {

        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<players.length; i++) {
            map.put(players[i], i);
        }

        for (String c : callings) {
            int index = map.get(c);
            String temp = players[index - 1];
            players[index-1] = players[index];
            players[index] = temp;

            map.put(c, map.get(c) - 1);
            map.put(temp, map.get(temp)+1);
        }

        return players;
    }
}
