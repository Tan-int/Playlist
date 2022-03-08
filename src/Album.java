import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;

public class Album {
    private ArrayList<Song> songList;
    private String artist;
    private String name;

    public Album(String artist, String name) {
        this.songList = new ArrayList<>();
        this.artist = artist;
        this.name = name;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> list) {
        Song song = findSong(title);
        if(song == null) {
            return false;
        }

        list.add(songList.get(songIndex(song)));
        return true;
    }

    public boolean addSong(String title, int minutes, int seconds) {
        Song song = findSong(title);
        if(song == null) {
            songList.add(new Song(title, minutes, seconds));
            return true;
        }

        return false;
    }

    private Song findSong(String title) {
        for(Song song: songList) {
            if(song.getTitle().equals(title.toLowerCase(Locale.ROOT))) {
                return song;
            }
        }
        return null;
    }

    private int songIndex(Song song) {
        return songList.indexOf(song);
    }

    public void albumList() {
        if(songList.isEmpty()) {
            System.out.println("No songs in this album");
            return;
        }

        System.out.println("Artist: " + artist);
        for(int i = 0; i < songList.size(); i++) {
            System.out.println((i + 1) + ". " + songList.get(i).toString());
        };
    }

}
