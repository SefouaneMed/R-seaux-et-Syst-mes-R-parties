package helloBoot;
import java.io.*;
import java.net.*;
public class srvr {
	public static void main(String[] args)throws IOException {
		ServerSocket ss = new ServerSocket(4999);
	while(true){
		Socket s = ss.accept();
		System.out.println("*****client connected*****");
		//to receive the statement
		InputStreamReader in = new InputStreamReader(s.getInputStream());
		BufferedReader bf = new BufferedReader(in);
		String str = bf.readLine() ;
		String str1 = bf.readLine() ;
		System.out.println("cliant:"+ str);
		System.out.println("cliant1:"+ str1);
		
		//to reply to client
		PrintWriter pr = new PrintWriter(s.getOutputStream());
		if (str.contains(str1)){
			pr.println(str+" contien: "+str1);
		}else{
			pr.println(str+" dont contien: "+str1);
		}
		pr.flush();
	}
}
}
