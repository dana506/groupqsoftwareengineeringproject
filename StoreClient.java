package StoreMode;

import java.io.*;

import java.net.*;

 /**
  * 
  * @author Dana Buzatu
  *
  */

public class StoreClient {
	/**
	 * Implements the client program that speaks to the StoreServer
	 * @throws UnknownHostException Doesn't recognise the host
	 * @throws IOException Can't get I/O for the connection to hostName
	 * 
	 */
    public static void main(String[] args) throws IOException {
         
        if (args.length != 2) {
            System.err.println(
                "Usage: java Client <host name> <port number>");
            System.exit(1);
        }
        
        //Class uses the second command line argument as the port number when creating its socket
        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);
 
        //  Socket that is connected to the server running on the specified host name and port
        try (
            Socket storeSocket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(storeSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(storeSocket.getInputStream()));
        ) {
            BufferedReader stdIn =
                new BufferedReader(new InputStreamReader(System.in));
            
    
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        }
    }
}
