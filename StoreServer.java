package StoreMode;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author Dana Buzatu
 *
 */

public class StoreServer {

	/**
	 * 
	 * Creating a new ServerSocket object to listen on a specific port
	 * @throws IOException Checking if the listening on port is possible
	 */
public static void main(String[] args) throws IOException {
        
        if (args.length != 1) {
            System.err.println("Usage: java StoreServer <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);
        
        //Gets the socket's input and output stream and opens readers and writers on them
        try ( 
            //ServerSocket object to listen on a specific port
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
        	//Server communicates with client after it successfully establishes a connection with a client
        	PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        ) {
        
            
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
