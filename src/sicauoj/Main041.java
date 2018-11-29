package sicauoj;

import java.util.Scanner;

/*
title:
川牛在考试       -Time Limit Exceeded

description:
一场英语考试共有N=(0,200]道题目，川牛凭借良好的蒙题能力完成了这次考试，但是他不清楚能不能通过这场考试
（假设满分一百，且每道题目的分值一样，需要60分以上才能通过考试）。
川牛向你求助，并向你提供了每道题目的猜对的概率Pi%，求你帮他算算他通过考试的概率。

input:
第一行将向你提供一个整数M=(0,100]，代表一共有M个测试用例。
随后将有M行，每行的第一个数N表示这场考试一共有N个题目，随后紧跟着N个概率Pi%，依次代表各个题目猜对的概率。

output:
每行输出通过考试的概率P（保留5位小数）。

sample input:
2
4 100 100 100 100
3 50 50 50

sample output:
1.00000
0.50000

hint:
 */

public class Main041
{

 static class Test
 {
  static boolean debug = false;
  float Pi[];

  public Test(Scanner scr)
  {
   Pi = new float[scr.nextInt()];
   for (int i = 0; i < Pi.length; i++)
   {
    Pi[i] = scr.nextFloat() / 100;
   }
  }

  public void run()
  {
   /*
     2
     4 100 100 100 100
     3 50 50 50
     0011
     0101
     0110
     1001
     1010
     1100
    */
   float p = 0, pi = 1;
   int n = (int) Math.ceil(0.6 * Pi.length);// ps: 至少要答对n道题
   boolean answer[];
   for (int i = n; i <= Pi.length; i++)
   {
    // ps: 答对i题的概率
    answer = new boolean[Pi.length];
    for (int j = 0; j < Pi.length; j++)
    {
     if (j < Pi.length - i) answer[j] = false;
     else answer[j] = true;
    }
    while (answer != null)
    {
     for (int k = answer.length - 1; k >= 0; k--)
     {
      if (answer[k])
      {
       pi *= Pi[k];
      }else
      {
       pi *= 1 - Pi[k];
      }
     }
     println(pi);
     p += pi;
     pi = 1;
     boolean find1 = false;
     for (int k = answer.length - 1; k >= 0; k--)
     {
      if (!find1 && answer[k])
      {
       find1 = true;
       continue;
      }
      if (find1 && !answer[k])
      {
       answer[k] = true;
       answer[k + 1] = false;
       break;
      }
      if (k == 0)
      {
       answer = null;
       println("clear answer");
      }
     }
    }
   }
   System.out.printf("%.5f\n", p);
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
