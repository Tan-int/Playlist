import java.util.LinkedList;

public class Playlist {
    private LinkedList<Song> playlist;

    public Playlist() {
        this.playlist = new LinkedList<>();
    }

    public void add(Song song) {
        playlist.add(song);
    }

    public boolean remove(Song song) {
        if(index(song) < 0) {
            return false;
        }
        playlist.remove(song);
        return true;
    }

    public Song replay(Song song) {
        return playlist.get(index(song));
    }

    public void playList() {
        if(playlist.isEmpty()) {
            System.out.println("Playlist is currently empty");
            return;
        }

        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + playlist.get(i).toString());
        }
    }

    public int index(Song song) {
        if(!playlist.contains(song)) {
            return -1;
        }
        return playlist.indexOf(song);
    }

}
