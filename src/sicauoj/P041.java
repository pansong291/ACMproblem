package sicauoj;

import java.util.Scanner;

/*
 * tm: 川牛在考试
 * 
 * ms: 一场英语考试共有N=(0,200]道题目，川牛凭借良好的蒙题能力完成了这次考试，但是他不清楚能不能通过这场考试
 * s   （假设满分一百，且每道题目的分值一样，需要60分以上才能通过考试）。
 * s    川牛向你求助，并向你提供了每道题目的猜对的概率Pi%，求你帮他算算他通过考试的概率。
 * 
 * sr: 第一行将向你提供一个整数M=(0,100]，代表一共有M个测试用例。
 * s   随后将有M行，每行的第一个数N表示这场考试一共有N个题目，随后紧跟着N个概率Pi%，依次代表各个题目猜对的概率。
 * 
 * sc: 每行输出通过考试的概率P（保留5位小数）。
 * 
 * ei: 2
 *     4 100 100 100 100
 *     3 50 50 50
 * 
 * eo: 1.00000
 *     0.50000
 * 
 * sl: 
 */

public class P041
{

 static class Test
 {
  boolean debug = true;

  public Test(Scanner scr)
  {
  }

  public void run()
  {
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
