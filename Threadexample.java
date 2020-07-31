import java.util.*;
public class Threadexample extends Thread{
public static void main(String[] args)
throws InterruptedException{
final PC pc=new PC();
Thread t1=new Thread(new Runnable(){
public void run(){
try{
pc.consume();
}
catch(InterruptedException e){
e.printStackTrace();
}
}
});
t1.start();
t2.start();
t1.join();
t2.join();
public static class PC{
try{
pc.consume();
}
catch(InterruptedException e){
e.printStackTrace();
}
}
}
t1.start();
t2.start();
t1.join();
t2.join();
public static class pc{
LinkedList<Integer>list=new LinkedList<>();
int capacity=2;
public void produce() throws InterruptedException{
int value=0;
while(true){
synchronized(this){
while(list.size()==capacity)
wait();
System.out.println("producer produced-"+value);
list.add(value++);
notify();
Thread.sleep(1000);
}
}
}
public void consume()throws InterruptedException
{
while(true){
syncronized(this);
{
while(list.size()==0)
wait();
int val=list.removeFirst();
System.out.println("Consumer consumed-"+val);
Notify();
Thread.sleep(1000);
}
}
}
}













