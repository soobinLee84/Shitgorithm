package PGS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PGS42579 {

    public static void main(String[] args) {
//        solution(new String[]{"classic", "pop", "classic", "classic", "pop"},
//            new int[]{500, 600, 150, 800, 2500});

        System.out.println(
            Arrays.toString(
                solution(new String[]{"classic"},
                    new int[]{500})));
    }

    public static int[] solution(String[] genres, int[] plays) {

        Map<String, Genre> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (!map.containsKey(genres[i])) {
                map.put(genres[i], new Genre(genres[i]));
            }

            map.get(genres[i]).addSong(new Song(i, plays[i]));
        }

        List<Genre> values = new ArrayList<>(map.values());
        Collections.sort(values, Comparator.comparingInt((a) -> a.totalSongPlay * -1));

        List<Integer> result = new ArrayList<>();
        for (Genre genre : values) {
            Collections.sort(genre.songs);
            int limit = Math.min(genre.songs.size(), 2);
            for (int j = 0; j < limit; j++) {
                result.add(genre.songs.get(j).code);
            }
        }

        return result.stream().mapToInt(a -> a).toArray();
    }

    private static class Genre {

        String genre;
        List<Song> songs;
        int totalSongPlay = 0;

        public Genre(String genre) {
            this.genre = genre;
            this.songs = new ArrayList<>();
        }

        public void addSong(Song song) {
            songs.add(song);
            totalSongPlay += song.play;
        }

        public int getTotalSong() {
            return songs.size();
        }
    }

    private static class Song implements Comparable<Song> {

        int code;
        int play;

        public Song(int code, int play) {
            this.code = code;
            this.play = play;
        }

        @Override
        public int compareTo(Song o) {
            if (this.play != o.play) {
                return o.play - this.play;
            }

            return this.code - o.code;
        }
    }

}
