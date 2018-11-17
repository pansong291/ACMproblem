package sicauoj;

import java.util.Arrays;
import java.util.Scanner;

/*
 * tm: 字母归类     --finish
 * 
 * ms: 将一个只包含大小写字母的字符串进行分类，按照大小写分类，并且分别按ASCII码大小进行升序排序，
 * m   然后依次输出小写字母序列和大写字母序列。
 * 
 * sr: 第一行将输入一个整数N=(0,1000]
 * s   随后将有N行测试用例，每一行都有一个只包含大小写字母的字符串，字符串长度l=(0,200]
 * 
 * sc: 对于每个测试用例，依次输出排序后的小写字母序列和大写字母序列，每两个字符之间有一个空格，每个测试用例占一行。
 * 
 * ei: 3
 *     aBc
 *     ACBacb
 *     asdf
 * 
 * eo: a c B
 *     a b c A B C
 *     a d f s
 * 
 * sl: 
 */

public class P034
{

 static class Test
 {
  boolean debug = true;
  String line;
  char[] chs;

  public Test(Scanner scr)
  {
   line = scr.nextLine();
   chs = line.toCharArray();
  }

  public void run()
  {
   Arrays.sort(chs);
   int j = -1;
   for (int i = 0; i < chs.length; i++)
   {
    if (chs[i] >= 'a')
    {
     if (j < 0) j = i;
     System.out.print(chs[i]);
     if (j > 0 || i < chs.length - 1) System.out.print(' ');
    }
   }
   if (j < 0) j = chs.length;
   for (int k = 0; k < j; k++)
   {
    System.out.print(chs[k]);
    if (k < j - 1) System.out.print(' ');
   }
   System.out.println();
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
