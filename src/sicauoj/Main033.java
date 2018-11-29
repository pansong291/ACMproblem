package sicauoj;

import java.util.LinkedList;
import java.util.Scanner;

/*
title:
鑫苑餐厅     --finish

description:
会员们请川牛做一个长方形的大蛋糕，但不知道这块大的长方形蛋糕是否能在圆圆的桌面上放得下。

input:
输入包含多个测试用例。每个测试用例占一行，以一个整数r=[1,1000]开始，即会员们所坐的圆桌表面的半径。
当r=0时结束。接下来的2个整数W=[1,L]和L=[W,1000]指定长方形蛋糕的宽度和长度。

output:
每个测试用例输出蛋糕是否适合桌面。一个只触摸桌子边缘而不交叉的蛋糕也被认为适合的。

sample input:
38 40 60
32 50 70
50 60 80
0

sample output:
cake 1 fits
cake 2 does not fit
cake 3 fits

hint:
 */

public class Main033
{

 static class Test
 {
  static boolean debug = true;
  int i, r, w, l;

  public Test(Scanner scr, int i, int r)
  {
   this.i = i;
   this.r = r;
   w = scr.nextInt();
   l = scr.nextInt();
  }

  public void run()
  {
   if (2 * r >= Math.sqrt(Math.pow(w, 2) + Math.pow(l, 2))) System.out.println("cake " + i + " fits");
   else System.out.println("cake " + i + " does not fit");
  }

  static void println(Object o)
  {
   if (debug) System.out.println(o);
  }

 }

 static LinkedList<Test> test;

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  test = new LinkedList<Test>();
  int r;
  for (int i = 0;; i++)
  {
   r = scr.nextInt();
   if (r == 0) break;
   test.add(new Test(scr, i + 1, r));
  }
  while (test.size() > 0)
  {
   test.removeFirst().run();
  }
 }

}
