//import java.io.IOException;
//import java.net.InetAddress;
//import java.util.List;
//
//
//public class GuitarServerMain {
//
//    public static void main(String[] args) throws IOException {
//        GuitarServer gs = new GuitarServer();
//        try {
//        	InetAddress inetAddress = InetAddress.getLocalHost();
//            gs.connect(inetAddress.getHostName(), E.port);
//            List<String> fileList = gs.getFileList();
//            println("server's File list (" + Server.DEFAULT_UPLOAD_PATH + ")");
//            for (String s: fileList) {
//                println(s);
//            }
//
//            if (fileList.size() > 0) {
//                gs.requestFile("C:/Users/Dana/eclipse-workspace/StoreServerClient", "./download/lala.txt");
//                println("done");
//            } else {
//
//            }
//            gs.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    private static void println(String str) throws IOException {
//        System.out.println(str);
//    }
//}