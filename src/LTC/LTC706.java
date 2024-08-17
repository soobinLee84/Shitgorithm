package LTC;


public class LTC706 {
    static class MyHashMap {
        int[] nodes = new int[1000000];

        public void put(int key, int value) {
            int index = key % nodes.length;
            nodes[index] = value + 1;
        }

        public int get(int key) {
            int index = key % nodes.length;

            if (nodes[index] == 0) return -1;

            return nodes[index] - 1;
        }

        public void remove(int key) {
            int index = key % nodes.length;
            nodes[index] = 0;
        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 1);
        System.out.println(map.get(1));
        map.put(2, 2);
        System.out.println(map.get(2));
        System.out.println(map.get(3));
        map.put(2, 1);
        System.out.println(map.get(2));


    }
}
