package nyoj.top;

import java.util.Scanner;

/*
 * tm: 奇偶数分离            --finish
 *
 * ms: 有一个整型偶数n(2<= n <=10000),你要做的是：先把1到n中的所有奇数从小到大输出，再把所有的偶数从小到大输出。
 *
 * sr: 第一行有一个整数i（2<=i<30)表示有 i 组测试数据；每组有一个整型偶数n。
 *
 * sc: 第一行输出所有的奇数；第二行输出所有的偶数
 *
 * ei: 2
 *     10
 *     14
 *
 * eo: 1 3 5 7 9
 *     2 4 6 8 10
 *
 *     1 3 5 7 9 11 13
 *     2 4 6 8 10 12 14
 *
 * sl:
 */

public class Main11
{
 static boolean debug = true;

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  int testCount = scr.nextInt();
  //  scr.nextLine();
  int num;

  while (testCount-- > 0)
  {
   num = scr.nextInt();
   for (int i = 1; i <= num; i += 2)
     System.out.print(i + " ");
   System.out.println();
   for (int i = 2; i <= num; i += 2)
     System.out.print(i + " ");
   System.out.println();
  }

  scr.close();
 }

 static void logPrintln(Object o)
 {
  if (debug) System.out.println(o);
 }

}
