public class TestThreadTwice1 extends Thread{
public void run(){
System.out.println("running....");
}
public static void main(String args[]){
TestThreadTwice1  T1=new TestThreadTwice1();
T1.start();
T1.start();
}
}