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

    /**
     * This will extract the contents of a zipped bundle into a temporary directory so that we can access the files
     * inside
     * @param zipFile The zipped bundle
     * @return A Bundle instance with references to the extracted contents
     */
    public static Bundle fromZipFile(File zipFile) {
        BundleExtractor extractor = new BundleExtractor(zipFile, new File("./tmp"));
        try {
            extractor.extract();
        } catch (DataFormatException e) {
            System.out.printf("Bundle %s is improperly formed", zipFile.getName());
            System.exit(-1);
        }

        return extractor.getBundle();
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
