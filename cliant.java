package helloBoot;
import java.net.*;
import java.io.*;
public class cliant {

	public static void main(String[] args) throws IOException{
		Socket s = new Socket("localhost",4999);
		System.out.println("Clian Abdress: "+ s.getLocalAddress()+ "->" + s.getLocalPort());
		System.out.println("Clian Abdress: "+ s.getInetAddress()+ "->" + s.getPort());
		// Keyboard input
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String msg = br.readLine();
		String msg1 = br.readLine();
		// to write something
		PrintWriter pr = new PrintWriter(s.getOutputStream());
		pr.println(msg);
		pr.flush();
		pr.println(msg1);
		pr.flush();
		//to  receive the 
		InputStreamReader in = new InputStreamReader(s.getInputStream());
		BufferedReader bf = new BufferedReader(in);
		String str = bf.readLine() ;
		System.out.println("sever:"+ str);
	}

}