import java.io.File;
import java.util.zip.DataFormatException;

/**
 * This class represents a bundle - it allows one to retrieve any of the files associated with each bundle (MIDI file,
 * artwork file and notes file)
 * @author Callum Browne
 */
public class Bundle {
    /**
     * The file containing the MIDI data
     */
    private File midiFile;

    /**
     * The file containing the artwork for this album (in PNG or JPEG form)
     */
    private File artworkFile;

    /**
     * The file containing the proprietary notes data
     */
    private File notesFile;

    public Bundle(File midiFile, File artworkFile, File notesFile) {
        this.midiFile = midiFile;
        this.artworkFile = artworkFile;
        this.notesFile = notesFile;
    }

    public File getMidiFile() {
        return midiFile;
    }

    public File getArtworkFile() {
        return artworkFile;
    }

    public File getNotesFile() {
        return notesFile;
    }
}
