import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;

// class Song is a container of song data and audio
public class Song { 

    // declare instance fields
    private String name; // full name of song
    private double bpm; // beats per minute of song
    private double npb; // notes per each beat of the song
    private ArrayList<Integer> keys; // list of the keys to be pressed in order in song
    private File infoFile; // text file with song info (full name, bpm, npb)
    private File keysFile; // text file containing song keys in order
    private int totalNotes; // total amount of notes in a song
    private int k; // counter representing current key that song is on

    public Song (String t) { // pass in title of song
        // initialize audio file and song data files using title
        infoFile = getFile(this, "files/" + t + "/" + t + ".txt");
        keysFile = getFile(this, "files/" + t + "/" + t + "_keys.txt");

        // initialize lists for keys and notes
        keys = new ArrayList<Integer>();

        // load song data from initialized files
        try { // try catch block to catch any thrown exceptions in file input
            // use scanner to load song info into variables
            Scanner s1 = new Scanner(infoFile);
            name = s1.nextLine();
            bpm = Double.parseDouble(s1.nextLine());
            npb = Double.parseDouble(s1.nextLine());
            s1.close();
            // use scanner to load keys into key list
            Scanner s2 = new Scanner(keysFile);
            while (s2.hasNextLine()) {
                int n = Integer.parseInt(s2.nextLine()); // retrieve next key from file
                if (n != 0) {
                    totalNotes++;
                } // if the key is not 0 (blank), add to total number of notes
                keys.add(n); // add key to list of keys
            }
            s2.close();
        } catch (Exception e) { // catch FileNotFoundExceptions and IOExceptions using the Exception superclass
            e.printStackTrace(); // print any caught exceptions
        }
        // set counters to -1, they increment immediately on event before any other code is run
        k = -1;
    }
    
    public static File getFile(Object object, String path) {
        try {
            return new File(object.getClass().getResource(path).toURI());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    // accessor method for bpm
    public double getBeatsPerMinute() {
        return bpm;
    }

    // accessor method for npb
    public double getNotesPerBeat() {
        return npb;
    }

    // accessor method for song's full name
    public String getName() {
        return name;
    }

    // accessor method for percentage correct
    public int getPercentage(int p) { // pass in points earned value
        return (int) (100 * p/totalNotes); // calculate a percentage using points earned parameter and total points possible, cast to int to truncate
    }

    // accessor method for the next key in the list of keys of the song
    public int nextKey() {
        k++; // increment key list counter
        if (k < keys.size()) return keys.get(k); // return current key
        else return 7; // return 7 if out of keys
    }
}
