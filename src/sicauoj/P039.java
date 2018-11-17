package sicauoj;

import java.util.Scanner;

/*
 * tm: 猜猜我是第几个      --finish
 * 
 * ms: 有这样的一堆十六进制数，它们长度均为15，它们自身均不含0且它们自身的每一位之间也互不相等
 * m   （如：425613879abcdef），所有满足上述条件的所有十六进制数组成了一个递增序列S。
 * m    现在从序列中选出一些数，你能快速的回答出这些数在原序列S中处于第几个位置嘛
 * 
 * sr: 第一行将输入一个整数N=(0,100]。随后将有N行测试用例，每一行都将随机给出数列S中的一个数。
 * 
 * sc: 输出每个测试用例在S序列中的位置，各占一行。
 * 
 * ei: 3
 *     123456789abcdef
 *     123456789abcdfe
 *     fedcba987654321
 * 
 * eo: 1
 *     2
 *     1307674368000
 * 
 * sl: 全排列序数法
 */

public class P039
{

 static class Test
 {
  static boolean debug = true;
  String line;

  public Test(Scanner scr)
  {
   line = scr.nextLine();
   if (debug) line = "fedcba987654321";
  }

  public void run()
  {
   long k = 1, ordinal = 1;
   int n = line.length();
   for (int i = n - 2; i >= 0; i--)
   {
    k *= n - i - 1;
    println("k*=" + (n - i - 1) + ", k=" + k);
    for (int j = i + 1; j < n; j++)
    {
     if (line.charAt(i) > line.charAt(j))
     {
      ordinal += k;
      println(line.charAt(i) + ">" + line.charAt(j) + ", +" + k + "=" + ordinal);
     }
    }
   }
   System.out.println(ordinal);
  }

  void println(Object o)
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
