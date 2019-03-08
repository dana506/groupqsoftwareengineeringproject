package StoreMode;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.util.zip.ZipEntry;
	import java.util.zip.ZipOutputStream;
	
	/** 
	 *@author Dana Buzatu
	 *ZipFile creates the Bundle zip file with 3 compressed files.
	 */

	public class ZipFile{
		
		/**
		 * Creates the Bundle as a zip archive
		 * @param bundleName the name the Bundle will receive
		 * @param midiFileName the midi file
		 * @param artworkFileName the artwork file
		 * @param notesFileName the notes file
		 */
		public static ZipFile createBundle(String bundleName, String midiFileName, String artworkFileName, String notesFileName) {

			try {
				FileOutputStream bundle = new FileOutputStream(bundleName);
				ZipOutputStream zos = new ZipOutputStream(bundle);
				
				String midiFile = midiFileName; 
				String artworkFile = artworkFileName;
				String notesFile = notesFileName;
				
				addToZipFile(midiFile, zos); //adding the midiFile to the zip
				addToZipFile(artworkFile, zos); //adding the artworkFile to the zip
				addToZipFile(notesFile, zos); //adding the mnotesFile to the zip
				
				zos.close();
				bundle.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		

		}
		
		/**
		 * addToZipFile method adds the file to the zip archive
		 * @param fileName
		 * @param zos, zip archive
		 * @throws FileNotFoundException, if the file couldn't be found
		 * @throws IOException
		 */
		
		public static void addToZipFile(String fileName, ZipOutputStream zos) throws FileNotFoundException, IOException {

			System.out.println("Writing '" + fileName + "' to " + zos);

			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file);
			// Creates a new zip entry with fields taken from the specified zip entry
			ZipEntry zipEntry = new ZipEntry(fileName);
			zos.putNextEntry(zipEntry);

			byte[] bytes = new byte[1024];
			int length;
			while ((length = fis.read(bytes)) >= 0) {
				zos.write(bytes, 0, length);
			}

			zos.closeEntry();
			fis.close();
		}

}
