package sicauoj;

import java.math.BigInteger;
import java.util.Scanner;

/*
 * tm: 大数相加     --finish
 * 
 * ms: 求解大数A和B之和。
 * 
 * sr: 第一行将输入一个整数N=(0,1000]。随后将有N行测试用例，每一行都有两个正整数A和B。（A和B的数值可能很大）
 * 
 * sc: 对于每个测试用例，输出A+B的和，每个测试用例占一行。
 * 
 * ei: 2
 *     1 2
 *     112233445566778899 998877665544332211
 * 
 * eo: 3
 *     1111111111111111110
 * 
 * sl: 
 */

public class P035
{

 static class Test
 {
  boolean debug = true;
  BigInteger bi1, bi2;

  public Test(Scanner scr)
  {
   bi1 = scr.nextBigInteger();
   bi2 = scr.nextBigInteger();
  }

  public void run()
  {
   System.out.println(bi1.add(bi2));
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
