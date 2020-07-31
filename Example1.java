import java.sql.*;
import java.util.*;
import java.sql.*;
import java.io.*;
public class Example1{
static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
static final String DB_URL="jdbc:mysql://localhost:3306/new database";
static final String USER="root";
static final String PASSWORD=" ";
public static void main(String args[]){
Connection con=null;
Statement stmt=null;
try{
Class.forName("com.mysql.jdbc.Driver");
System.out.println("connecting database");
con=DriverManager.getConnection(DB_URL,USER,PASSWORD);
System.out.println("creating statement");
stmt=con.createStatement();
String query;

File file=new File("read.txt");
BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
String line;
while((line=br.readLine())!=null)
{
String [ ]  tokens=line.split("\\5+");
           String var_1=tokens[0];
           String var_2=tokens[1];
           String var_3=tokens[2];
           String var_4=tokens[3];
int roll_number,marks,persentage;
roll_number=Integer.parseInt(var_2);
marks=Integer.parseInt(var_3);
persentage=Integer.parseInt(var_4);
System.out.println(var_1);
System.out.println(roll_number);
System.out.println(marks);
System.out.println(persentage);
persentage=Integer.parseInt(var_4);
System.out.println(var_1);
System.out.println(roll_number);
System.out.println(marks);
System.out.println(persentage);




query="INSERT INTO 'student1'(  'name' ,  'roll_number',  'marks',  'persentage') VALUES(' "+var_1+" ' ,'"+roll_number+"','"+marks+"','"+persentage+"')";
stmt.executeUpdate(query);
}
System.out.println("Data Inserted");
stmt.close();
con.close();
}
catch(SQLException se){
se.printStackTrace();
}catch(Exception e){
e.printStackTrace();
}
finally{
try
{
if(stmt!=null)
stmt.close();
}catch(SQLException se2){
}
try
{
if(con!=null)
con.close();
}catch(SQLException se){
se.printStackTrace();
}
}
}
}





