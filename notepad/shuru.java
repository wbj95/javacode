import java.util.Scanner;
public class shuru{
  public static void main(String[] args){
   Scanner sc=new Scanner(System.in);
   int age=sc.nextInt();
   int age1=sc.nextInt();
   if(age<age1){
   System.out.println(age1);
   }
   else
  {
   System.out.println(age);
   }
   sc.close();
  }
}