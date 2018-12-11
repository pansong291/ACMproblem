package nyoj.top;

import java.util.Scanner;

/*
title:
买水果         --finish

description:
今天zz突然想吃水果了，然后他到超市去买水果，现超市有n个不同的水果，zz要买m个水果
（m<=n）;那么zz有多少种买水果的方式？

input:
输入T组数据（T<=100）
然后输入T行，每行输入两个数n，m（0< n < 2^31）

output:
每一行输出一个数（保证在0~2^31）

sample input:
2
4 2
3 3

sample output:
6
1

hint:

 */

public class Main1131
{
 static boolean debug = true;
 static final Scanner scr = new Scanner(System.in);

 public static void main(String[] args)
 {
  int testCount = scr.nextInt();
  long n, m, sum;

  while (testCount-- > 0)
  {
   n = scr.nextLong();
   m = scr.nextLong();
   sum = 1;
   m = m <= n - m ? m : n - m;
   for (int i = 0; i < m; i++)
   {
    sum = sum * (n - i) / (i + 1); // 为了保证不丢失精度，必须这么写
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
