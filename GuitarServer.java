//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.net.InetAddress;
//import java.net.Socket;
//import java.util.LinkedList;
//import java.util.List;
//
//public class GuitarServer {
//    private int port = 8080; //match the E port
//    private Socket socket;
// BufferedReader lineReader;
//	public GuitarServer() {
//
//    }
//
//    public void close() throws IOException {
//        if (!socket.isClosed())
//            socket.close();
//    }
//
//    public void connect(String localhost, int port) throws IOException {
//
//    	//getting the local host for the machine on which this is run
//    	InetAddress inetAddress = InetAddress.getLocalHost();
//		socket = new Socket(inetAddress.getHostName(), port);
//
//        writeMsg(Server.REQ_WELCOME); //sending "welcome to server"
//        println(readLine()); // welcome
//    }
//
//    public void writeMsg(String str) throws IOException {
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//        writer.write(str + "\n");
//        writer.flush();
//    }
//
//
//    public String readLine() throws IOException {
//        if (lineReader == null)
//            lineReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        return  lineReader.readLine();
//    }
//
//   //created a List of strings (files paths)
//    public List<String> getFileList() throws IOException {
//        writeMsg(Server.REQ_FILE_LIST);
//        LinkedList<String> fileList = new LinkedList<String>();
//        while(true){
//            String line = readLine();
//            if (line.split(Server.LIST_DELIMITER)[0].equals("File")){
//                fileList.add(line.split(Server.LIST_DELIMITER)[1]);
//            } else if (line.equals("ENDOFLIST")){
//                break;
//            }
//        }
//        return fileList;
//    }
//
//
//    public void requestFile(String fileName, String outPath) throws IOException {
//        writeMsg(Server.GET_FILE + " " + fileName);//sending the get message to our server
//        File file = new File(outPath); //getting the file from server
//        File parent = new File(file.getParent());
//
//        // if the directory does not exist, create it
//
//        if (!parent.exists()) {
//            println("creating directory: " + fileName);
//            boolean result = false;
//
//            try{
//                parent.mkdir();
//                result = true;
//            }
//            catch(SecurityException se){
//                //handle it
//            }
//            if(result) {
//                println("DIR created : " + parent.getPath());
//            }
//        }
//
//        byte[] buf = new byte[16*1024];
//
//        InputStream inputStream = socket.getInputStream();
//        FileOutputStream fileOutputStream = new FileOutputStream(file);
//        int count = inputStream.read(buf);
//        do {
//            fileOutputStream.write(buf, 0, count);
//            count = inputStream.read(buf);
//        } while (count > 0); //checking the size of the file
//        fileOutputStream.close();
//    }
//
//    private void println(String s) {
//        System.out.println(s);
//    }
//
//	public int getPort() {
//		return port;
//	}
//
//	public void setPort(int port) {
//		this.port = port;
//	}
//}
