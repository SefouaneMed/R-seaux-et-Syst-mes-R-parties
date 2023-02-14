package helloBoot;

import java.io.*;
import java.net.*;

public class Dsrvr {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(4999);
		while (true) {
			Socket s = ss.accept();
			System.out.println("*****client connected*****");
			// to receive the statement
			DataInputStream dis = new DataInputStream(s.getInputStream());
			String str = (String)dis.readUTF();
			String str1 = (String)dis.readUTF();
			System.out.println("cliant:" + str);
			System.out.println("cliant1:" + str1);

			// to reply to client
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			if (str.contains(str1)) {
				System.out.println(str + " contien: " + str1);
			} else {
				System.out.println(str + " dont contien: " + str1);
			}

		}
	}
}
