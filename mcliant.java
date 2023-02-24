import java.net.*;
import java.io.*;
public class mcliant{ 
  public static void main(String argv[]){
    
    int port= 5555; 
  String adr="localhost";
try {
  Socket soc = new Socket(adr,port);
  System.out.println("Client address: " + soc.getLocalAddress() + ":" + soc.getLocalPort());
  System.out.println("Server address: " + soc.getInetAddress() + ":" + soc.getPort());
 // InputStreamReader reader = new InputStreamReader(soc.getInputStream());
  BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
System.out.println("Entrer la premier chaine : ");
String chaine_1 = is.readLine();
System.out.println("Entrer le deuxieme chaine : ");
String chaine_2 = is.readLine();
ObjectOutputStream output = new ObjectOutputStream(soc.getOutputStream());
  ObjectInputStream input = new ObjectInputStream(soc.getInputStream());
  output.writeObject(chaine_1);
  output.flush();
  output.writeObject(chaine_2);
  output.flush();
  String reponse = (String) input.readObject();
  System.out.println("the answer of server is : " + reponse);
  //soc.close();
}catch (Exception e) {System.err.println("Erreur : "+e);}
}}