import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.net.InetAddress;

//public class GuitarServerDemo {
//
///**
//*
//*@author Dana Buzatu
//*Guitar Sever, here acts as a client, receiving bundles from Store Manager Mode (acting as server)
//*
//*/
//
//	private static Socket sgs; //guitar server socket end
//	private static FileOutputStream fsm;
//	InetAddress inetAddress = InetAddress.getLocalHost(); //getting the host code
//
//	public static void main(String[] args) throws Exception {
//
//		byte []b= new byte [20002];
//
//		sgs = new Socket (inetAddress.getHostAddress(), 8080);
//		InputStream igs = sgs.getInputStream();
//
//		fsm = new FileOutputStream ("C:/Users/Dana/Desktop/filemoved.zip"); //rename the file to be moved
//
//		igs.read(b, 0, b.length);
//		fsm.write(b, 0, b.length);
//
//	}
//}
