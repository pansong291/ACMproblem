package sicauoj;

import java.util.Scanner;

/*
title:
最小二进制数       -finish

description:
小明得到了这样一个二进制数比如10011001，他可以在这个数上做这样两种操作：
交换任意两个相邻的二进制位
将数位中1111消解为11
注意每次操作后，不能0打头，现在小明有这样的一个数s，他可以执行任意次这样的操作，使得最后的二进制数最小。
请你帮助他输出最后的二进制数

input:
第一行一个整数n=[1,100]代表二进制数位数，第二行一个二进制数s

output:
结果二进制数

sample input:
4
1001

sample output:
100

sample input 2:
1
0

sample output 2:
0

hint:
注意n的范围会超出int和long的范围
 */

public class Main002
{
 static boolean debug = true;

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  String str;
  int c0 = 0, c1 = 0, i0 = 1;
  scr.nextLine();
  str = scr.nextLine();
  scr.close();

  for (int j = 0; j < str.length(); j++)
  {
   if (str.charAt(j) == '0')
   {
    c0++;
    i0 *= 10;
   }else
   {
    c1++;
   }
  }
  if (c1 == 0) System.out.println(0);
  else
  {
   println(i0);
   System.out.print(1);
   for (int i = 0; i < c0; i++)
   {
    System.out.print(0);
   }
  }
 }

 static void println(Object o)
 {
  if (debug) System.out.println(o);
 }

}
