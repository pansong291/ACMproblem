package top.nyoj;

import java.util.Arrays;
import java.util.Scanner;

/*
 * tm: ASCII码排序     --finish
 * 
 * ms: 输入三个字符（可以重复）后，按各字符的ASCII码从小到大的顺序输出这三个字符。
 * 
 * sr: 第一行输入一个数N,表示有N组测试数据。后面的N行输入多组数据，每组输入数据都是占一行，有三个字符组成，之间无空格。
 * 
 * sc: 对于每组输入数据，输出一行，字符中间用一个空格分开。
 * 
 * ei: 2
 *     qwe
 *     asd
 * 
 * eo: e q w
 *     a d s
 * 
 * sl: 
 */

public class Main4
{

 static class Test
 {
  static boolean debug = true;
  char[] chas;

  public Test(Scanner scr)
  {
   String line = scr.nextLine();
   chas = line.toCharArray();
   Arrays.sort(chas);
  }

  public void run()
  {
   for (int i = 0; i < chas.length; i++)
   {
    System.out.print(chas[i]);
    if (i != chas.length - 1) System.out.print(' ');
   }
   System.out.println();
  }

  static void println(Object o)
  {
   if (debug) System.out.println(o);
  }

 }

 static Test test[];

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  test = new Test[scr.nextInt()];
  scr.nextLine();
  for (int i = 0; i < test.length; i++)
  {
   test[i] = new Test(scr);
  }
  for (int i = 0; i < test.length; i++)
  {
   test[i].run();
  }
 }

}
