import java.util.Locale;

public class Song {
    private String title;
    private int minutes;
    private int seconds;

    public Song(String title, int minutes, int seconds) {
        this.title = title.toLowerCase(Locale.ROOT);
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Title: " + capitalize(title) + " (" + minutes + "M " + seconds + "S)";
    }

    public String capitalize(String title) {
        return title.substring(0, 1).toUpperCase() + title.substring(1);
    }
}
