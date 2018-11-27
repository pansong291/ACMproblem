package acm.hfut.edu.cn;

import java.math.BigInteger;
import java.util.Scanner;

/*
tm:
八进制转十六进制

ms:
s的长度为[1,10000]
输入串没有前导0，当然，你的输出也不能含有前导0

sr:
第一行为一个整数T，表示数据的组数,一下T行 每行一个八进制数字串s

sc:
对于每组数据输出对应的十六进制字串

ei:
4
7
77
233
2333333333333333333

eo:
7
3F
9B
9B6DB6DB6DB6DB

sl:
 */

public class Main1342
{
 static boolean debug = false;

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  int testCount = scr.nextInt();
  BigInteger num;

  while (testCount-- > 0)
  {
   num = scr.nextBigInteger(8);
   System.out.println(num.toString(16).toUpperCase());
  }
  scr.close();
 }

 static void logPrintln(Object o)
 {
  if (debug) System.out.println(o);
 }

}
