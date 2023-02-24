import java.net.*;
import java.io.*;
public class msrvr extends Thread{
  static int nbcl;
private Socket socket;
public static void main(String argv[]){try{
ServerSocket svrsk = new ServerSocket(5555);
while (true) // est-il necessaire ?
{Socket socketclient = svrsk.accept();nbcl++;
  System.out.println("*****client connected="+nbcl+"*****");
msrvr t=new msrvr (socketclient); 
t.start();}}
catch (Exception e){ e.printStackTrace();}}
public msrvr(Socket socket){
this.socket=socket;}
public void run(){
  try{  
    ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
    ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
    String str1 = (String) input.readObject();
    String str2 = (String) input.readObject();
    System.out.println("cliant1:"+ str1);
		System.out.println("cliant1:"+ str2);
    if (str1.contains(str2)) {
    output.writeObject(str1 + " contient " + str2);} 
    else {
    output.writeObject(str1 + " ne contient pas " + str2);}
   output.flush();
   //soc.close();//s.close();
  }  
  catch(Exception e) {System.err.println("Erreur: "+e);}
  }}