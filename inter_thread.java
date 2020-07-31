package multi_threading;
public class inter_thread implements Runnable{
static inter_thread obj;
boolean val=false;
Thread t;
public inter_thread()
{

}
public inter_thread(String msg)
{
t=new Thread(msg);
t.start();
}
public static void main(String args[]){
inter_thread obj=new inter_thread();
inter_thread obj1=new inter_thread("Child1");
inter_thread obj2=new inter_thread("Child2");
try{
obj1.t.join();
obj2.t.join();
}
catch(InterruptedException e){
System.out.println("Interrupted");
}
}
public void run(){
int i;
synchronized(obj)
{
for(i=1;i<=5;i++){
System.out.println(i);
val=!val;
while(val)
try{
wait();
}
catch(InterruptedException e){
System.out.println("Interrupted");
}
notify();
}
}
}
}