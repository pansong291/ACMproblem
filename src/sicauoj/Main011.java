package sicauoj;

import java.util.Scanner;

/*
tm:
水仙花数            --finish

ms:
水仙花数是指一个 n 位数 ( n >= 3 )，它的每个位上的数字的 n 次幂之和等于它本身。（例如：1^3 + 5^3 + 3^3 = 153）
给出一个整数M，求 >= M的最小的水仙花数。

sr:
一个整数M（10 <= M <= 1000）

sc:
输出>= M的最小的水仙花数

ei:
100

eo:
153

sl:
 */

public class Main011
{
 static boolean debug = true;

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  int num = scr.nextInt();

  for (;; num++)
  {
   if (isSXH(num))
   {
    System.out.println(num);
    break;
   }
  }

  scr.close();
 }

 static boolean isSXH(int n)
 {
  int sum = 0, len = lengthOf(n);
  for (int i = n; i > 0; i /= 10)
   sum += Math.pow(i % 10, len);

  return sum == n;
 }

 static int lengthOf(int i)
 {
  int c = 0;
  for (; i > 0; c++)
   i /= 10;
  return c;
 }

 static void logPrintln(Object o)
 {
  if (debug) System.out.println(o);
 }

}
