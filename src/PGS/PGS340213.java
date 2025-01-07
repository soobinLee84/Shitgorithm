package PGS;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class PGS340213 {

    public String solution(String video_len, String pos, String op_start, String op_end,
        String[] commands) {

        Video v = new Video(video_len, pos, op_start, op_end);

        for (String c : commands) {
            if ("next".equals(c)) {
                v.next();
            } else if ("prev".equals(c)) {
                v.prev();
            }
        }

        return v.getPos();
    }

    class Video {

        LocalTime videoLen;
        LocalTime opStart;
        LocalTime opEnd;
        LocalTime pos;

        public Video(String video_len, String pos, String op_start, String op_end) {
            this.videoLen = LocalTime.parse("00:" + video_len);
            this.pos = LocalTime.parse("00:" + pos);
            this.opStart = LocalTime.parse("00:" + op_start);
            this.opEnd = LocalTime.parse("00:" + op_end);

            skipOp();
        }

        // 10초 전으로 이동
        public void prev() {
            // 현재 위치가 10초 미만인 경우 0분 0초로 이동
            if (pos.isBefore(LocalTime.parse("00:00:10"))) {
                pos = LocalTime.parse("00:00:00");
            } else {
                pos = pos.minusSeconds(10);
            }

            skipOp();
        }

        // 10초 후로 이동
        public void next() {
            // 남은 시간이 10초 미만일 경우 마지막 위치로 이동
            if (pos.isAfter(videoLen.minusSeconds(10))) {
                pos = videoLen;
            } else {
                pos = pos.plusSeconds(10);
            }

            skipOp();
        }

        // 오프닝 건너뛰기
        public void skipOp() {
            // 오프닝 기간인 경우 오픈닝이 끝나는 위치로 이동
            if (pos.isBefore(opStart) || pos.isAfter(opEnd)) {
                return;
            }

            pos = opEnd;
        }

        public String getPos() {
            return pos.format(DateTimeFormatter.ofPattern("mm:ss"));
        }
    }
}
