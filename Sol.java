import java.util.*;
class my{
public static int power(int n,int p)throws Exception{
if(n<0||p<0){
throw new Exception("n or p should not be negative.");
}
else if(n==0&&p==0){
throw new Exception("n and p should not be zero.");
}
else{
return((int)Math.pow(n,p));
}
}
}
public class Sol{
public static final my my_calculator=new my();
public static final Scanner in=new Scanner(System.in);
public static void main(String args[]){
System.out.println("Enter num and value of power")
while(in.hasNextInt())
{
int n=in.nextInt();
int p=in.nextInt();
try{
System.out.println(my_calculator.power(n,p));
}
catch(Exception e){
System.out.println(e);
}
}
}
}






