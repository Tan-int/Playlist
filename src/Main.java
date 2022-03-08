import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Album bad = new Album("Micheal Jackson", "Bad");
    private static LinkedList<Song> playlist = new LinkedList<>();

    public static void main(String[] args) {
        bad.addSong("Bad", 4, 8);
        bad.addSong("The Way You Make Me Feel", 4, 59);
        bad.addSong("Speed Demon", 4,3);
        bad.addSong("Liberian Girl", 3,55);
        bad.addSong("Just Good Friends", 4,9);
        bad.addSong("Another Part Of Me", 3,55);
        bad.addSong("Man in the Mirror", 5,21);
        bad.addSong("I Just Can't Stop Loving You", 4,27);
        bad.addSong("Dirty Diana", 4,42);
        bad.addSong("Smooth Criminal", 4,20);

        bad.addToPlaylist("Bad", playlist);
        bad.addToPlaylist("dirty diana", playlist);
        bad.addToPlaylist("smooth criminal", playlist);
        bad.addToPlaylist("Liberian Girl", playlist);
        bad.addToPlaylist("Man in the Mirror", playlist);
        bad.addToPlaylist("Speed Demon", playlist);

        play(playlist);

    }

    private static void playlistOptions() {
        System.out.println(
                "----- Playlist Options ----- \n" +
                "1. Replay Song\n" +
                "2. Remove Song\n" +
                "3. Next Song\n" +
                "4. Previous Song\n" +
                "5. View Playlist\n" +
                "6. View Album\n" +
                "7. Print Menu\n" +
                "8. Quit");
    }

    private static void play(LinkedList<Song> playlist) {
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> i = playlist.listIterator();
        playlistOptions();

        System.out.println("Now playing: " + i.next().toString());

        while(!quit) {
            System.out.print("Option: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    if(i.hasNext()) {
                        if(forward) {
                            if(i.hasPrevious()) {
                                System.out.println("Now playing: " + i.previous().toString());
                                forward = false;
                            } else {
                                System.out.println("Reached the beginning of the playlist");
                            }
                        } else{
                            if(i.hasNext()) {
                                System.out.println("Now playing: " + i.next().toString());
                                forward = true;
                            } else {
                                System.out.println("Reached the end of the playlist");
                            }
                        }
                    }
                    break;
                case "2":
                    if(!forward) {
                        if(i.hasNext()) {
                            i.next();
                            System.out.println("Song removed: " + i.previous().toString());
                            i.remove();
                            if(i.hasNext()) {
                                System.out.println("Now playing: " + i.next().toString());
                            } else if(i.hasPrevious()) {
                                System.out.println("Now playing: " + i.previous().toString());
                            } else {
                                System.out.println("Playlist is empty");
                            }
                        } else {
                            System.out.println("Not currently playing a song");
                        }
                    } else if (forward) {
                        if(i.hasPrevious()) {
                            i.previous();
                            System.out.println("Song removed " + i.next().toString());
                            i.remove();
                            if(i.hasNext()) {
                                System.out.println("Now playing: " + i.next().toString());
                            } else if(i.hasPrevious()) {
                                System.out.println("Now playing: " + i.previous().toString());
                            } else {
                                System.out.println("Playlist is empty");
                            }
                        } else {
                            System.out.println("Not currently playing a song");
                        }
                    }
                    break;
                case "3":
                    if(i.hasNext()) {
                        if(!forward) {
                            i.next();
                            forward = true;
                        }
                        System.out.println("Now playing: " + i.next().toString());
                    } else {
                        System.out.println("Reached the end of the playlist");
                    }
                    break;
                case "4":
                    if(i.hasPrevious()) {
                        if(forward) {
                            i.previous();
                            System.out.println("\nNow playing: " + i.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("Now playing: " + i.previous().toString());
                        }
                    } else {
                        System.out.println("Reached the beginning of the playlist");
                    }
                    break;
                case "5":
                    printPlaylist(playlist);
                    break;
                case "6":
                    bad.albumList();
                    break;
                case "8":
                    System.out.println("Program ended");
                    quit = true;
                    break;
                default:
                    try {
                        int num = Integer.parseInt(choice);
                        System.out.println("Please select a valid option");
                    } catch (Exception e) {
                        System.out.println("Please select a valid option");
                    }
            }
        }
    }

    private static void printPlaylist(LinkedList<Song> list) {
        ListIterator<Song> i = list.listIterator();
        if(list.isEmpty()) {
            System.out.println("Playlist is empty");
            return;
        }

        while(i.hasNext()) {
            System.out.println(i.next().toString());
        }
    }
}
