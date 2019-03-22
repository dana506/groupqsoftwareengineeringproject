import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.jar.JarFile;
import java.util.zip.*;


public class StoreModeManager {
    /**
     * Launches an interactive sequence with the user to create a bundle
     *
     * TODO ziping files together at the end.
     * @author  Pierre de Brosses
     *
     */
    public static void importNewBundle() {

        final JFileChooser fc = new JFileChooser();
        String AlbumCoverPath = "null.null";
        String MidiPath = "null.null";
        //Extension filters
            FileNameExtensionFilter midi = new FileNameExtensionFilter(" Midi files", "midi", "mid");
            FileNameExtensionFilter img = new FileNameExtensionFilter(" *png", "png");

        //Choosing the midi file
            fc.setFileFilter(midi);
            JOptionPane.showMessageDialog(null, "Please select a midi file");
            fc.showOpenDialog(null);
            while ( ! ( fc.getSelectedFile().getAbsolutePath().endsWith(".midi") //avoids user clicking all files and
                        || fc.getSelectedFile().getAbsolutePath().endsWith(".mid") ) ) { // setting a pdf as the midi file
                fc.showOpenDialog(null);
            }
            MidiPath = fc.getSelectedFile().getAbsolutePath();


        //Choosing the album cover
            fc.setFileFilter(img);
            Object[] yesNo = {"Yes", "No"};

            int choice = JOptionPane.showOptionDialog(null, "Would you like to choose an album cover ?",
                "Please make a choice", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, yesNo, yesNo[0]);
            if (choice == 0){
                fc.showOpenDialog(null);
                while ( ! (fc.getSelectedFile().getAbsolutePath().endsWith(".png"))) {
                fc.showOpenDialog(null);
            }
                AlbumCoverPath = fc.getSelectedFile().getAbsolutePath();
            }
            else {
                AlbumCoverPath = "./defaultAlbumCover.png";
            }

        //Choosing the right midi track
            Object[] options = {"Preview 1", "Preview 2", "Preview 3", "Preview 4",
                    "Preview 5","Preview 6", "Preview 7", "Preview 8",
                    "Preview 9", "Preview 10", "Preview 11", "Preview 12",
                    "Preview 13", "Preview 14", "Preview 15", "Preview 16",
                    1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};


            int trackChoice = 0;
            while (trackChoice <16) {
                Midi.playTrack(MidiPath, trackChoice+1);
                trackChoice = JOptionPane.showOptionDialog(null, "Please choose a track to set as the main track\n You can preview a track X by clicking preview X",
                        "Please make a choice", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, options, options[0]);

            }
        String packageName = JOptionPane.showInputDialog(null, "Please name the package?");

    }


    private static void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
        if (fileToZip.isHidden()) {
            return;
        }
        if (fileToZip.isDirectory()) {
            if (fileName.endsWith("/")) {
                zipOut.putNextEntry(new ZipEntry(fileName));
                zipOut.closeEntry();
            } else {
                zipOut.putNextEntry(new ZipEntry(fileName + "/"));
                zipOut.closeEntry();
            }
            File[] children = fileToZip.listFiles();
            for (File childFile : children) {
                zipFile(childFile, fileName + "/" + childFile.getName(), zipOut);
            }
            return;
        }
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileName);
        zipOut.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
        fis.close();
    }


    private static String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // empty extension
        }
        return name.substring(lastIndexOf);
    }
}

