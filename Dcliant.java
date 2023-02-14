package helloBoot;

import java.net.*;
import java.io.*;

public class Dcliant {

	public static void main(String[] args) throws IOException {
		Socket s = new Socket("localhost", 4999);
		System.out.println("Clian Abdress: " + s.getLocalAddress() + "->" + s.getLocalPort());
		System.out.println("Clian Abdress: " + s.getInetAddress() + "->" + s.getPort());
		// Keyboard input
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String msg = br.readLine();
		String msg1 = br.readLine();
		// to write something
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		dos.writeUTF(msg);
		dos.writeUTF(msg1);
		// to receive the
		DataInputStream dis = new DataInputStream(s.getInputStream());
		String str = (String)dis.readUTF();
		System.out.println("sever:" + str);
	}

}