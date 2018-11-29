package nyoj.top;

import java.util.Scanner;

/*
title:
喷水装置（二）

description:
有一块草坪，横向长w,纵向长为h,在它的橫向中心线上不同位置处装有n(n<=10000)个点状的喷水装置，
每个喷水装置i喷水的效果是让以它为中心半径为Ri的圆都被润湿。请在给出的喷水装置中选择尽量少的喷水装置，把整个草坪全部润湿。

input:
第一行输入一个正整数N表示共有n次测试数据。每一组测试数据的第一行有三个整数n,w,h，
n表示共有n个喷水装置，w表示草坪的横向长度，h表示草坪的纵向长度。
随后的n行，都有两个整数xi和ri,xi表示第i个喷水装置的的横坐标（最左边为0），ri表示该喷水装置能覆盖的圆的半径。

output:
每组测试数据输出一个正整数，表示共需要多少个喷水装置，每个输出单独占一行。
如果不存在一种能够把整个草坪湿润的方案，请输出0。

sample input:
2
2 8 6
1 1
4 5
2 10 6
4 5
6 5

sample output:
1
2

hint:
 */
/*
2
6 20 2
1 2
2 4
6 2
10 5
14 3
19 2
7 20 2
1 2
2 4
6 2
10 5
14 3
19 2
10 2
*/
public class Main12
{
 static boolean debug = true;
 static int w, h;
 static Round round[];

 static class Round
 {
  int x, r;
  float x1, x2; // 能够覆盖到的x范围
  float xl; // 覆盖宽度
  boolean checked = false; // 已被选中
  boolean outed = false; // 已被排除

  public Round(int x, int r)
  {
   this.x = x;
   this.r = r;
   if (2 * r <= h)
   {
    xl = 0;
    x1 = x2 = x;
   }else
   {
    xl = (float) Math.sqrt(4 * r * r - h * h) / 2;
    x1 = x - xl;
    x2 = x + xl;
    if (x1 < 0) x1 = 0;
    if (x2 > w) x2 = w;
    xl = x2 - x1;
   }
  }
 }

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  int testCount = scr.nextInt();
  //  scr.nextLine();
  float coverX1, coverX2; // 被覆盖的区域
  int maxCi, checkedCount, outedCount;

  while (testCount-- > 0)
  {
   round = new Round[scr.nextInt()];
   w = scr.nextInt();
   h = scr.nextInt();
   coverX1 = 0;
   coverX2 = 0;
   checkedCount = 0;
   outedCount = 0;
   for (int i = 0; i < round.length; i++)
   {
    round[i] = new Round(scr.nextInt(), scr.nextInt());
   }

   do
   {
    maxCi = -1;
    if (coverX1 == coverX2)
    {
     for (int i = 0; i < round.length; i++)
     {
      if (round[i].checked || round[i].outed) continue;
      if (maxCi < 0 || round[maxCi].xl < round[i].xl) maxCi = i;
     }
     logPrintln("装置x:" + round[maxCi].x + " 已选");
     coverX1 = round[maxCi].x1;
     coverX2 = round[maxCi].x2;
    }else
    {
     for (int i = 0; i < round.length; i++)
     {
      if (round[i].checked || round[i].outed) continue;
      if (maxCi < 0) maxCi = i;
      else
      {
       float areaM, areaI;
       if (round[i].x2 < coverX1 || round[i].x1 > coverX2) continue; // 无交集
       else areaI = Math.max(round[i].x2, coverX2) - Math.min(round[i].x1, coverX1);

       if (round[maxCi].x2 < coverX1 || round[maxCi].x1 > coverX2) // 无交集
       {
        maxCi = i;
        continue;
       }else areaM = Math.max(round[maxCi].x2, coverX2) - Math.min(round[maxCi].x1, coverX1);

       if (areaI <= coverX2 - coverX1)
       {
        if (!round[i].outed) outedCount++;
        round[i].outed = true;
       }

       if (areaM <= coverX2 - coverX1)
       {
        if (!round[maxCi].outed) outedCount++;
        round[maxCi].outed = true;
       }

       if ((round[i].x1 < coverX1 && round[maxCi].x1 < coverX1) || (round[i].x2 > coverX2 && round[maxCi].x2 > coverX2))
       {
        if (areaM < areaI)
        {
         if (!round[maxCi].outed) outedCount++;
         round[maxCi].outed = true;
         maxCi = i;
        }else
        {
         if (!round[i].outed) outedCount++;
         round[i].outed = true;
        }
       }else if (areaM < areaI) maxCi = i;
      }
     }
     if (maxCi < 0) // 找不到方案使整个草坪湿润
     {
      logPrintln("maxCi < 0,无法润湿整个草坪");
      checkedCount = 0;
      break;
     }else if (checkedCount + outedCount == round.length - 1)
     {
      if (round[maxCi].x2 < coverX1 || round[maxCi].x1 > coverX2)// 无交集
      {
       logPrintln("无交集,无法润湿整个草坪");
       checkedCount = 0;
       break;
      }else if (coverX2 - coverX1 >= Math.max(round[maxCi].x2, coverX2) - Math.min(round[maxCi].x1, coverX1))
      {
       logPrintln("被包含,无法润湿整个草坪");
       checkedCount = 0;
       break;
      }
     }
     logPrintln("装置x:" + round[maxCi].x + " 已选");
     coverX1 = Math.min(round[maxCi].x1, coverX1);
     coverX2 = Math.max(round[maxCi].x2, coverX2);
    }
    round[maxCi].checked = true;
    checkedCount++;
   }while (coverX1 > 0 || coverX2 < w);
   System.out.println(checkedCount);

  }

  scr.close();
 }

 /*
 2
 2 8 6
 1 1
 4 5
 2 10 6
 4 5
 6 5
 */
 static void logPrintln(Object o)
 {
  if (debug) System.out.println(o);
 }

}
