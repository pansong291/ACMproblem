package nyoj.top;

import java.util.Scanner;

/*
 * tm: 街区最短路径问题         --finish
 * 
 * ms: 一个街区有很多住户，街区的街道只能为东西、南北两种方向。住户只可以沿着街道行走。各个街道之间的间隔相等。
 * m   用(x,y)来表示住户坐在的街区。例如（4,20），表示用户在东西方向第4个街道，南北方向第20个街道。
 * m   现在要建一个邮局，使得各个住户到邮局的距离之和最少。求现在这个邮局应该建在那个地方使得所有住户距离之和最小；
 * 
 * sr: 第一行一个整数n<20，表示有n组测试数据，下面是n组数据；
 * s   每组第一行一个整数m<20,表示本组有m个住户，下面的m行每行有两个整数0<x,y<100，表示某个用户所在街区的坐标。
 *     m行后是新一组的数据；
 * 
 * sc: 每组数据输出到邮局最小的距离和，回车结束；
 * 
 * ei: 2
 *     3
 *     1 1
 *     2 1
 *     1 2
 *     5
 *     2 9 
 *     5 20
 *     11 9
 *     1 1
 *     1 20
 * 
 * eo: 2
 *     44
 * 
 * sl: 
 */

public class Main7
{

 static class Test
 {
  static boolean debug = false;
  int[] x, y;
  int maxX = 0, maxY = 0;

  public Test(Scanner scr)
  {
   x = new int[scr.nextInt()];
   y = new int[x.length];
   scr.nextLine();
   for (int i = 0; i < x.length; i++)
   {
    x[i] = scr.nextInt();
    y[i] = scr.nextInt();
    if (maxX < x[i]) maxX = x[i];
    if (maxY < y[i]) maxY = y[i];
   }
  }

  public void run()
  {
   int minDist = -1, temp;
   println("maxX=" + maxX + ",maxY=" + maxY);
   for (int i = 1; i <= maxX; i++)
   {
    for (int j = 1; j <= maxY; j++)
    {
     println("check i=" + i + ",j=" + j);
     temp = 0;
     for (int k = 0; k < x.length; k++)
     {
      temp += Math.abs(i - x[k]) + Math.abs(j - y[k]);
     }
     println("temp=" + temp);
     if (minDist < 0 || minDist > temp) minDist = temp;
     println("minDist=" + minDist);
    }
   }
   System.out.println(minDist);
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
