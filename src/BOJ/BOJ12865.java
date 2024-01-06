package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BOJ12865 {

    static Set<String> result = new HashSet<>();

    static class Item {
        private int w;
        private int v;

        public Item(int w, int v) {
            this.w = w;
            this.v = v;
        }

        public Item(String s) {
            String[] splitString = s.split(" ");
            this.w = Integer.parseInt(splitString[0]);
            this.v = Integer.parseInt(splitString[1]);
        }

        public int getW() {
            return w;
        }

        public int getV() {
            return v;
        }

        @Override
        public String toString() {
            return "Item(" +
                    "w=" + getW() +
                    ", v=" + getV() +
                    ')';
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");

        int n = Integer.parseInt(a[0]);
        int k = Integer.parseInt(a[1]);

        String[] inputs = new String[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = br.readLine();
        }

        List<Item> list = new ArrayList<>();
        int realN = 0;
        for (int i = 0; i < n; i++) {
            String[] splitString = inputs[i].split(" ");
            if (Integer.parseInt(splitString[0]) <= k) {
                list.add(new Item(Integer.parseInt(splitString[0]), Integer.parseInt(splitString[1])));
                realN++;
            }
        }
        n = realN;

        System.out.println(combination(list, k));
    }

    public static int combination(List<Item> list, int k) {
        rec_combination(list, 0, "", k, 0);

        int maxV = 0;
        for (String v : result) {
            int sumV = 0;
            String[] splitV = v.split(" ");
            for (int i = 0; i < splitV.length; i++) {
                sumV += list.get(Integer.parseInt(splitV[i])).getV();
            }
            maxV = Math.max(maxV, sumV);
        }

        return maxV;
    }

    private static void rec_combination(List<Item> list, int depth, String visited, int k, int sumW) {

        if (list.size() - 1 < depth) {
            if (!visited.isEmpty())
                result.add(visited);
            return;
        }

        Item item = list.get(depth);

        //추가
        if (sumW + item.getW() > k && !visited.isEmpty()) {
            result.add(visited);
        } else {
            rec_combination(list, depth + 1, depth + " " + visited, k, sumW + item.getW());
        }

        //안함
        rec_combination(list, depth + 1, visited, k, sumW);

    }

}
