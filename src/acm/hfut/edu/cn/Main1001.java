package acm.hfut.edu.cn;

import java.util.Scanner;

/*
tm:
洗牌问题

ms:
设2n张牌分别标记为1，2，…，n，n+l，…，2n，初始时这2n张牌按其标号从小到大排列。
经一次洗牌后，原来的排列顺序变成n+l，l，n+2，2，··，，2n，n。
即前n张牌被放到偶数位置2，4，·，·，2n，而后n张牌被放到奇数位置1，3，…，2n-l。
可以证明对于任何一个自然数n，经过若干次洗牌后可恢复初始状态。
编程任务:对于给定的n的值(n<=24000)，编程计算最少经过多少次洗牌可恢复到初始状态。

sr:
由键盘输入n的值。输入包含多组数据，每行一个整数N。

sc:
程序运行结束时，将计算出的最少洗牌次数在屏幕上输出。对于输入的N，输出最少需要的洗牌次数。

ei:
10

eo:
6

sl:
 */

public class Main1001
{
 static boolean debug = true;

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  int n;

  while (scr.hasNextInt())
  {
   n = scr.nextInt();

  }

  scr.close();
 }

 static void logPrintln(Object o)
 {
  if (debug) System.out.println(o);
 }

}
