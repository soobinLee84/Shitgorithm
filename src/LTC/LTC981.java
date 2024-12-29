package LTC;

import java.util.*;

public class LTC981 {

    private static class ValueInfo {
        String value;
        int timestamp;

        public ValueInfo(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    static class TimeMap {
        Map<String, List<ValueInfo>> map = new HashMap<>();

        public TimeMap() {

        }

        public void set(String key, String value, int timestamp) {
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(new ValueInfo(value, timestamp));
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) {
                return "";
            }

            List<ValueInfo> valueInfos = map.get(key);
            String result = "";
            for (int i = valueInfos.size() - 1; i >= 0; i--) {
                ValueInfo info = valueInfos.get(i);
                if (info.timestamp <= timestamp) {
                    result = info.value;
                    break;
                }
            }

            return result;
        }
    }

    static class TimeMap3 {
        Map<String, TreeMap<Integer, String>> map = new HashMap<>();

        public TimeMap3() {

        }

        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key)) {
                map.put(key, new TreeMap<>());
            }

            map.get(key).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            TreeMap<Integer, String> valueMap = map.get(key);
            if (valueMap == null) {
                return "";
            }

            Integer t = valueMap.floorKey(timestamp);

            return t == null ? "" : valueMap.get(t);
        }
    }
}
