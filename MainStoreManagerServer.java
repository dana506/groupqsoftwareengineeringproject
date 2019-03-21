//
//import java.io.*;
//import java.net.InetAddress;
//import java.util.List;
//
//
//public class MainStoreManagerServer {
//
//    public static void main(String[] args) throws IOException {
//        new Thread(new Runnable() {
//            public void run() {
//                try {
//                    StoreManager server = new StoreManager(E.port);
//                    server.open();
//                    while (true);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//            public void run() {
//                GuitarServer client = new GuitarServer();
//                try {
//                	InetAddress inetAddress = InetAddress.getLocalHost();
//                    client.connect(inetAddress.getHostName(), E.port);
//                    println(client.readLine());
//                    List<String> fileList = client.getFileList();
//                    println("server's File list (" + Server.DEFAULT_UPLOAD_PATH + ")");
//                    for (String s: fileList) {
//                        println(s);
//                    }
//
//                    if (fileList.size() > 0) {
//                        client.requestFile("C:/Users/Dana/eclipse-workspace/StoreServerClient", "./download/lala.txt");
//                        println("done");
//                    } else {
//
//                    }
//                    client.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }
//
//    private static void println(String str) throws IOException {
//        System.out.println(str);
//    }
//}