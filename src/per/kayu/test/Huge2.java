package per.kayu.test;
import java.math.*;
import java.io.*;
import java.util.*;
public class Huge2{
 public static void main(String[] args)
 {
  Scanner cin=new Scanner(System.in);
  BigInteger dp[]=new BigInteger[1001];
  dp[1]=BigInteger.ONE;
  for(int i=2;i<=1000;i++)
   dp[i]=dp[i-1].multiply(BigInteger.valueOf(i));
  int t,n;
  t=cin.nextInt();
  BigInteger sum;
  for(int i=1;i<=t;i++)
  {
   n=cin.nextInt();
   sum=BigInteger.ZERO;
   for(int j=1;j<=n;j++) 
    sum=sum.add(dp[j]);
   System.out.println(sum);
  }
  }
}