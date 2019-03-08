import java.io.*;
import java.util.zip.DataFormatException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * This class is responsible for extracting a zipped bundle so that we can then access the bundle's data
 * @author Callum Browne
 */
public class BundleExtractor {
    /**
     * The zip file to be extracted
     */
    private File zipFile;

    /**
     * The directory to extract to. Note - the files will not be placed directly within this directory but rather
     * a new directory will be created here to contain the files
     */
    private File destinationDir;

    /**
     * This is the Bundle object that is created after extraction
     */
    private Bundle bundle;

    public BundleExtractor(File zipFile, File destinationDir) {
        this.zipFile = zipFile;
        this.destinationDir = destinationDir;
    }

    /**
     * Perform the extraction
     */
    public void extract() throws DataFormatException {
        // First create the input streams
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(zipFile);
        } catch (FileNotFoundException e) {
            System.out.println("zip archive " + zipFile.getAbsolutePath() + " not found");
            System.exit(-1);
        }
        ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);

        // Before extracting we must first create a directory within the destination directory, with the same name as
        // the zipped file (excluding the file extension)
        String outputDirPath = destinationDir.getAbsolutePath()
                + File.separator
                + zipFile.getName().substring(0, zipFile.getName().lastIndexOf('.'));
        (new File(outputDirPath)).mkdirs();

        // These will be assigned later when we determine which file is which
        File midiFile = null;
        File artworkFile = null;
        File notesFile = null;

        // Go over each file in the zipped folder and copy it to the designated directory
        byte[] buffer = new byte[1024];
        try{
            ZipEntry zipEntry = zipInputStream.getNextEntry();
            while(zipEntry != null) {
                String filename = zipEntry.getName();
                File outputFile = new File(outputDirPath + File.separator + filename);

                // Determine what type of file this is and assign it to the appropriate variable - or throw an exception
                // if this is a file that should not exist
                if(filename.endsWith(".midi")) {
                    midiFile = outputFile;
                }
                else if(filename.endsWith(".png") || filename.endsWith(".jpg")) {
                    artworkFile = outputFile;
                }
                else if(filename.endsWith(".notes")) {
                    notesFile = outputFile;
                }
                else {
                    throw new DataFormatException("Unsupported file type found: " + filename);
                }

                FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
                int length;
                while((length = zipInputStream.read(buffer)) > 0) {
                    fileOutputStream.write(buffer, 0, length);
                }
                fileOutputStream.close();
                zipInputStream.closeEntry();

                zipEntry = zipInputStream.getNextEntry();
            }
        }
        catch(IOException e) {
            System.out.println("IO exception");
            e.printStackTrace();
            System.exit(-1);
        }

        // Check that all the necessary files are present
        if(midiFile == null) {
            throw new DataFormatException("No MIDI file present in zip archive");
        }
        if(artworkFile == null) {
            throw new DataFormatException("No artwork file present in zip archive");
        }
        if(notesFile == null) {
            throw new DataFormatException("No notes file present in zip archive");
        }

        bundle = new Bundle(midiFile, artworkFile, notesFile);
    }

    public Bundle getBundle() {
        return bundle;
    }
}
