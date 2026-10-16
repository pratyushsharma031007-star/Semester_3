package InheritanceandPolymorphism.Assignment_Problem;

import java.util.Arrays;
import java.util.Scanner;

class Playlist {
    private String[] songs;
    private int songCount;

    Playlist(int maxSongs) {
        songs = new String[maxSongs];
        songCount = 0;
    }

    void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        } else {
            System.out.println("Playlist is full");
        }
    }

    String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    int getSongCount() {
        return songCount;
    }
}

public class PlaylistManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum number of songs: ");
        int maxSongs = sc.nextInt();
        sc.nextLine();

        Playlist playlist = new Playlist(maxSongs);

        System.out.print("Enter number of songs: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter song " + (i + 1) + ": ");
            String song = sc.nextLine();
            playlist.addSong(song);
        }

        String[] copy = playlist.getSongs();

        System.out.println("Songs in playlist:");
        for (String song : copy) {
            System.out.println(song);
        }

        System.out.println("Song count: " + playlist.getSongCount());
    }
}
