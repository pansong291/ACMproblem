package sicauoj;

import java.util.Scanner;

/*
 * tm: 川牛的作业    --finish
 * 
 * ms: 川牛有很多科的作业没有做。而每门科目的作业都有最后期限。
 * m   若川牛在最后期限之后完成作业，对应科目的总成绩将会被扣除一定的分数。
 * m   假设每门科目的作业都需要1天的时间完成。川牛希望你能帮他决定完成所有作业的顺序使得扣除的分数最小。
 * 
 * sr: 第一行将输入一个整数T=(0,1000]
 * s   随后将有T个测试用例，每个测试用例是以一个整数N=[1,1000]开始，表示作业数量。
 * s   之后两行，第一行包含N个作业的最后期限，第二行是是N个作业未准时完成的扣除分数。
 * 
 * sc: 对于每个测试用例，输出扣除分数总和的最小值，各占一行。
 * 
 * ei: 3
 *     2
 *     2 2
 *     8 5
 *     3
 *     1 1 3
 *     4 5 2
 *     7
 *     1 4 6 4 2 4 3
 *     3 2 1 7 6 5 4
 * 
 * eo: 0
 *     4
 *     5
 * 
 * sl: 首先所扣分数按照降序排列，然后取第一个，从他所给期限的最晚时间开始安排，
 * s   如果这一天已经有安排，安排到前一天。。。这样先让扣分最多的有着落，最后剩下扣分少的
 * s   如果前面的所有天都有安排，则该份作业必然被扣分
 */

public class P037
{
 static class Node
 {
  int day, score;
  boolean flag;
 }

 static class Test
 {
  int n;
  Node zy[];
  boolean isFull[];
  int all = 0;

  public Test(Scanner scr)
  {
   n = scr.nextInt();
   zy = new Node[n];
   isFull = new boolean[n];
   for (int j = 0; j < n; j++)
   {
    zy[j] = new Node();
    zy[j].day = scr.nextInt();
   }
   for (int j = 0; j < n; j++)
   {
    zy[j].score = scr.nextInt();
   }
  }

  public void run()
  {
   Node max;

   while ((max = opMaxScore()) != null)
   {
    for (int i = max.day - 1; i >= 0; i--)
    {
     if (i >= isFull.length) break;
     if (!isFull[i])
     {
      isFull[i] = true;
      break;
     }
     if (i == 0)
     {
      all += max.score;
     }
    }
   }
   System.out.println(all);
  }

  Node opMaxScore()
  {
   int first = -1;
   for (int i = 0; i < n; i++)
   {
    if (zy[i].flag) continue;
    first = i;
    break;
   }
   if (first < 0) return null;
   for (int i = first + 1; i < n; i++)
   {
    if (zy[i].flag) continue;
    if (zy[first].score < zy[i].score)
    {
     first = i;
    }
   }
   zy[first].flag = true;
   return zy[first];
  }

 }

 static Test test[];

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  test = new Test[scr.nextInt()];
  // scr.nextLine();
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
