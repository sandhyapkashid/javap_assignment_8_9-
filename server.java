import java.util.*;
import java.iio.*;
import java.net.*;
public class server{
static Vector<ClientHandler>ar=new Vector<>();
static int i=0;
public static void main(String args[])throws IOException{
ServerSocket ss=new ServerSocket(1234);
Socket s;
while(true){
s=ss.accept();
System.out.println("New client request recieved:"+s);
DataInputStream dis=new DataInputStream(s.getInputStream());
DataOutputStream                    dos                      =                      new
DataOutputStream(s.getOutputStream());
System.out.println("Creating a new handler for this client...");
ClientHandler mtch=new ClientHandler(s,"client"+i,dis,dos);
Thread t=new Thread(mtch);
System.out.println("Adding this client to active client list");
ar.add(mtch);
t.start();
}
}
}
class ClientHandler implements Runnable{
Scanner scn=new Scanner(System.in);
private String name;
final DataInputStream dis;
final DataOutputStream dos;
Socket s;
boolean isloggedin;
public ClientHandler(Socket s,String name,DataInputStream dis,DataOutputStream dos){
this.dis=dis;
this.dos=dos;
this.name=name;
this.s=s;
this.isloggedin=true;
}
public void run(){
String recieved;
while(true)
try{
recieved=dis.readUTF();
System.out.println(recieved);
if(recieved.equals("logout")){
this.isloggedin=false;
this.s.close();
break;
}
StringTokenizer st=new StringTokenizer(recieved,"#");
String MsgToSend=st.nextToken();
String recipient=st.nextToken();
for(ClientHandler mc:Server.ar)
{
if(mc.name.equals(recipient)&&mc.isloggedin==true){
mc.dos.writeUTF(this.name+":"+MsgToSend);
break;
}
}
}
catch(IOException e){
e.printStackTrace();
}
}
try{
this.dis.close();
this.dos.close();
}catch(IOException e){
e.printStackTrace();}
}