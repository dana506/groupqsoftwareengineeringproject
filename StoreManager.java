import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author Dana Buzatu
 * 
 *
 */

public class StoreManager extends E{

  
    public static final String DEFAULT_UPLOAD_PATH = "./upload";

    public static final String REQ_WELCOME = "welcome";
   
    private static final String WELCOME_MSG = "Welcome to Store Manager\n";
    
    public static final String REQ_FILE_LIST = "fileList";
  
    public static final String GET_FILE = "get";
   
    public static final String LIST_DELIMITER = ":";
    
    //declaring the port and upload path as final

    private final String uploadPath;

    //establishing StoreManager's socket as a ServerSocket server and Socket socket for the Client part which weirdly is going to be our actual server which acts as a client for this part of bundle being created in store manager and saved on actual server
    private BufferedWriter out;
    private BufferedReader in;
    private final ServerSocket server;
    private Socket socket;

    private Thread serverThread;

    private boolean printLog;

	private InputStream in1;

    public StoreManager(int port) throws IOException {
        this.printLog = true;
        E.port = port;
        this.server = new ServerSocket(port);
        this.uploadPath = DEFAULT_UPLOAD_PATH;
    }

    //constructor initiate for port and printLog also the server for the specific port and the upload path is default
    public StoreManager(int port, boolean printLog) throws IOException {
        this.printLog = printLog;
        E.port = port;
        this.server = new ServerSocket(port);
        this.uploadPath = DEFAULT_UPLOAD_PATH;
    }
    
    //constructor this time gets the actual upload path
    public StoreManager(int port, boolean printLog, String uploadPath) throws IOException {
        this.printLog = printLog;
        E.port = port;
        this.server = new ServerSocket(port);
        this.uploadPath = uploadPath;
    }
    
    //establishing communication with the client which here is our "Server"
    public void open() throws IOException {
        serverThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    String msg;
                    try {
                        msg =StoreManager.this.readLine(); //message received from client(Server Guitar)
                        Thread.sleep(1000);
                        print("server received : " + msg);
                        if (msg.equals(REQ_WELCOME)) { //required welcome message is "welcome"
                            writeMsg(WELCOME_MSG);
                        } else if (msg.equals(REQ_FILE_LIST)) { //asking for the files list
                            StoreManager.this.writeFileList(); //the Store Manager writes the contents of the file list
                        } else {
                            if (msg.split(" ")[0].equals(GET_FILE)){ //if the file is required
                                StoreManager.this.writeFile(msg.split(" ")[1]); //message received by our server (Store Manager) for writing the filr
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        
        socket = server.accept(); //client's socket (Server Guitar) accepts the server part of socket connection 
        in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //from client
        serverThread.start(); 
    }

    private void print(String s) {
        if (printLog)
            System.out.println(s);
    }

    public String readLine() throws IOException {
        return in.readLine();
    }


    public void writeFileList() throws IOException {
        if (out == null){
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); //from client
        }
        out.write(getFileList(uploadPath) + "ENDOFLIST\n"); //adding a "flag" to grab attention as it is the end of fileList
        out.flush();
    }

    public void writeMsg(String msg) throws IOException{
        while (!socket.isConnected());
        
        if (out == null){
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        }
        out.write(msg + "\n");
        out.flush();
    }


    private String getFileList(@NotNull String path) { //as long as the parameter path is not null
        File folder = new File(path); //folder created in requested location
        File[] listOfFiles = folder.listFiles(); //array to hold the files
        
        StringBuilder sb = new StringBuilder();
        
        //adding to the list either a file of a directory
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                sb.append("File:" + listOfFiles[i].getName() + "\n");
            } else if (listOfFiles[i].isDirectory()) {
                sb.append("Directory:" + listOfFiles[i].getName() + "\n");
            }
        }
        return sb.toString();
    }

    public void writeFile(String path) throws IOException {
        File f = new File(uploadPath + "/" + path);
        if (f.isFile() && f.canRead()){
            in1 = new FileInputStream(f);
            OutputStream out = socket.getOutputStream(); //output streeam get the output stream from the socket end of the client (Guitar Server)
            int count = 0;
            byte[] buf = new byte[16*1024]; //enough space
            count = in1.read(buf); //get size
            do {
                out.write(buf, 0, count);
                count = in1.read(buf);
            } while (count > 0);
            out.flush();
        } else {

        }
    }

	
	
}
