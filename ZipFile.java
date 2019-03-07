import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.util.zip.ZipEntry;
	import java.util.zip.ZipOutputStream;
	
	/** @author Dana Buzatu
	 *
	 */

	public class ZipFile{

		public static void createBundle(String bundleName, String file1name, String file2name, String file3name) {

			try {
				FileOutputStream bundle = new FileOutputStream(bundleName);
				ZipOutputStream zos = new ZipOutputStream(bundle);
				
				String file1 = file1name;
				String file2 = file2name;
				String file3 = file3name;
				
				addToZipFile(file1, zos);
				addToZipFile(file2, zos);
				addToZipFile(file3, zos);
				
				zos.close();
				bundle.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		public static void addToZipFile(String fileName, ZipOutputStream zos) throws FileNotFoundException, IOException {

			System.out.println("Writing '" + fileName + "' to " + zos);

			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file);
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
