package acm.hfut.edu.cn;

import java.util.Scanner;

/*
title:
求和           --finish

description:
对于正整数n,k，我们定义这样一个函数f，它满足如下规律
f(n,k=1)=-1+2-3+4-5+6...n
f(n,k=2)=-1-2+3+4-5-6...n
f(n,k=3)=-1-2-3+4+5+6...n
f(n,k=4)=-1-2-3-4+5+6+7+8...n
现在给出n和k，你的任务就是要计算f(n,k)的值。

input:
首先是一个整数T，表示有T组数据，接下来每组数据是n和k(1<=n,k<=100000000)

output:
打印出f(n,k)的值，每个输出单独占一行

sample input:
3
1 1
2 1
3 1

sample output:
-1
1
-2

hint:
用循环的话，时间复杂度就太高了，因为n和k的值可以大到一亿
观察函数式可以找到规律，每组以2k为周期的和是k的平方
 */

public class Main1344
{
 static boolean debug = false;

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  int testCount = scr.nextInt();
  //  scr.nextLine();
  long n, k, t; // t是周期的个数
  // 以k个减号、k个加号为一个周期，所以周期为2倍k
  long sum;

  while (testCount-- > 0)
  {
   n = scr.nextInt();
   k = scr.nextInt();
   sum = 0;

   t = n / (2 * k); // 求出t个完整周期
   sum += t * k * k; // 每一个周期的和都是k的平方
   t = t * (2 * k) + 1; // 剩下的最后一个不完整周期的第一个数

   if (t <= n)
   {
    if (n - t >= k) // 如果最后一个不完整周期大于半周期k
    {
     // 先减去前半周期
     sum -= (t + t + k - 1) * k / 2;
     // 再加上后半周期(不完整的)
     sum += (t + k + n) * (n - (t + k) + 1) / 2;
    }else // 减去前半周期(不完整的)
     sum -= (t + n) * (n - t + 1) / 2;
    // 这些表达式是等差数列的求和公式
    // (首项 + 末项) * 项数 / 2
   }

   System.out.println(sum);
  }

  scr.close();
 }

 static void logPrintln(Object o)
 {
  if (debug) System.out.println(o);
 }

}
