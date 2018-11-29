package nyoj.top;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/*
title:
一种排序         --finish

description:
现在有很多长方形，每一个长方形都有一个编号，这个编号可以重复；还知道这个长方形的宽和长，编号、长、宽都是整数；
现在要求按照以下方式排序（默认排序规则都是从小到大）；1、按照编号从小到大排序 2、对于编号相等的长方形，按照长方形的长排序；
3、如果编号和长都相同，按照长方形的宽排序；4、如果编号、长、宽都相同，就只保留一个长方形用于排序,删除多余的长方形；
最后排好序按照指定格式显示所有的长方形；

input:
第一行有一个整数 0<n<10000,表示接下来有n组测试数据；每一组第一行有一个整数 0<m<1000，表示有m个长方形；
接下来的m行，每一行有三个数 ，第一个数表示长方形的编号，第二个和第三个数值大的表示长，数值小的表示宽，相等
说明这是一个正方形（数据约定长宽与编号都小于10000）；

output:
顺序输出每组数据的所有符合条件的长方形的 编号 长 宽

sample input:
1
8
1 1 1
1 1 1
1 1 2
1 2 1
1 2 2
2 1 1
2 1 2
2 2 1

sample output:
1 1 1
1 2 1
1 2 2
2 1 1
2 2 1

hint:
 */

public class Main8
{
 static boolean debug = true;

 static class Rectangle
 {
  int num, len, wid;
 }

 static class MyComparator implements Comparator<Rectangle>
 {

  @Override
  public int compare(Rectangle o1, Rectangle o2)
  {
   if (o1.num > o2.num) return 1;
   else if (o1.num < o2.num) return -1;
   else if (o1.len > o2.len) return 1;
   else if (o1.len < o2.len) return -1;
   else if (o1.wid > o2.wid) return 1;
   else if (o1.wid < o2.wid) return -1;
   return 0;
  }

 }

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  int testCount = scr.nextInt();
  //  scr.nextLine();
  TreeSet<Rectangle> rects = new TreeSet<>(new MyComparator());
  int temp;
  Rectangle last = null;

  while (testCount-- > 0)
  {
   for (int i = scr.nextInt(); i > 0; i--)
   {
    last = new Rectangle();
    last.num = scr.nextInt();
    last.len = scr.nextInt();
    last.wid = scr.nextInt();
    if (last.len < last.wid)
    {
     temp = last.len;
     last.len = last.wid;
     last.wid = temp;
    }
    rects.add(last);
   }


   for (Rectangle r : rects)
   {
    System.out.println(r.num + " " + r.len + " " + r.wid);
   }
   rects.clear();
  }

  scr.close();
 }

 static void logPrintln(Object o)
 {
  if (debug) System.out.println(o);
 }

}
