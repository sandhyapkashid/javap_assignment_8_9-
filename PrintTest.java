public class PrintTest{
public static void main(String args[]){
PrintNumbers b=new PrintNumbers();
One firstThread=new One(b);
Two secondThread=new Two(b);
Three thirdThread=new Three(b);
socondThread.setName("Second:");
thirdThread.setName("Third:");
firstThread.setName("First:");
firstThread.start();
secondThread.start();
thirdThread.start();
}
}