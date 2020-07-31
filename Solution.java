import java.security.SecureRandom;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
class Account{
int balance=0;
public String deposit(int money){
balance+=money;
return "Depositing $"+money;
}
public String withdraw(int money){
if(balance<money){
return "Withdraw $"+money+"(Insufficient Balance)";
}else{
balance-=money;
return "Withdraw $"+money;
}
}
public int getBalance(){
return balance;
}
}
class Transaction{
Account account=new Account();
List<String>transactions=new ArrayList<>();
public Transaction(Account account){
this.account=account;
}
public void deposit(int money){
transactions.add(account.deposit(money));
}
public void withdraw(int money){
transactions.add(account.withdraw(money));
}
public List<String>getTransaction(){
return transactions;
}
}
public class Solution{
private static final Scanner SCANNER=new Scanner(System.in);
private static final Account ACCOUNT=new Account();
private static final Transaction TRANSACTION=new Transaction(ACCOUNT);
public static void main(String args[])throws InterruptedException{
int threadsCount =Integer.parseInt(SCANNER.nextLine());
Thread[] threads=new Thread[threadsCount];
int expectedTransactionCount=0;
for(int i=0;i<threadsCount;i++){
int transactionsCount=Integer.parseInt(SCANNER.nextLine());
expectedTransactionCount+=transactionsCount;
threads[i]=new Thread(new  TransactionsRunnable(TRANSACTION,transactionsCount));
}
for(int i=0;i<threadsCount;i++){
threads[i].start();
}
for(int i=0;i<threadsCount;i++){
threads[i].join();
}
List<String>transactions=TRANSACTION.getTransaction();
if(transactions.size()!=expectedTransactionCount){
System.out.println("Wrong Answer");
}else{
boolean correct=true;
for(String transaction:transactions){
if(transaction==null){
correct=false;
break;
}
}
if(!correct){
System.out.println("Wrong Answer");
}else{
int balance=ACCOUNT.getBalance();
if(balance<0){
System.out.println("Wrong Answer");
}else{
for(String transaction:transactions){
System.out.println(transaction);
}
System.out.println("Balance $"+balance);
}
}
}
}
}