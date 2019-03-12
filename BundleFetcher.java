import java.io.File;
import java.util.ArrayList;
import java.util.zip.DataFormatException;

/**
 * This class loads all of the available bundles that the user may select
 * @author Callum Browne
 */
public class BundleFetcher {
    /**
     * @param bundleDirectory The directory in which the zipped bundles are saved
     * @return An ArrayList of Bundle instances representing each bundle
     */
    public static ArrayList<Bundle> fetchAllBundles(File bundleDirectory) {
        ArrayList<Bundle> bundles = new ArrayList<>();

        BundleExtractor extractor = new BundleExtractor(new File("./tmp"));
        for(File file: bundleDirectory.listFiles()) {
            try {
                Bundle bundle = extractor.extract(file);
                bundles.add(bundle);
            } catch (DataFormatException e) {
                System.out.printf("Error: file %s is not a valid bundle. Continuing as this is non-crticial...", file.getName());
            }
        }

        return bundles;
    }
}
