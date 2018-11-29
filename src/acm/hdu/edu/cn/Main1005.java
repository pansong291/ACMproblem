package acm.hdu.edu.cn;

import java.util.Scanner;

/*
title:
Number Sequence         --finish

description:
A number sequence is defined as follows:
f(1) = 1, f(2) = 1, f(n) = (A * f(n - 1) + B * f(n - 2)) mod 7.
Given A, B, and n, you are to calculate the value of f(n).

input:
The input consists of multiple test cases. Each test case contains 3 integers A, B
and n on a single line (1 <= A, B <= 1000, 1 <= n <= 100,000,000). Three zeros signal
the end of input and this test case is not to be processed.

output:
For each test case, print the value of f(n) on a single line.

sample input:
1 1 3
1 2 10
0 0 0

sample output:
2
5

hint:

 */

public class Main1005
{
 static boolean debug = true;
 static int A, B, n;

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  long temp1 = 1, temp2 = 1, temp;

  while (true)
  {
   A = scr.nextInt();
   B = scr.nextInt();
   n = scr.nextInt();
   if (A == 0 && B == 0 && n == 0) break;
   //System.out.println(dg(n));

   A %= 7; // 优化，减少计算量
   B %= 7;
   n %= 49;
   /*
    * ps: f(n) % 7 故 f(n) 取值 0 - 6
    * ps: 所以(f(n-1), f(n-2))只有49种取法，所以在A与B给定的前提下f(n)也只有49种可能
    * ps: 猜测这是个循环序列（猜测！！！）
    */
   for (int i = 1; i <= n; i++)
   {
    if (i < 3) temp1 = temp2 = 1;
    else
    {
     temp = temp1;
     temp1 = (A * temp1 + B * temp2) % 7;
     temp2 = temp;
    }
   }
   System.out.println(temp1);
  }

  scr.close();
 }

 static long dg(int n)
 {
  if (n < 3) return 1;
  return (A * dg(n - 1) + B * dg(n - 2)) % 7;
 }

 static void logPrintln(Object o)
 {
  if (debug) System.out.println(o);
 }

}
