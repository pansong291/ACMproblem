package sicauoj;

import java.util.LinkedList;
import java.util.Scanner;

/*
 * tm: 打工送货
 *
 * ms: 运输公司规定每个司机每天最多只能工作10小时，然后在指定的一家签定了免费入住协议的连锁酒店休息一晚。
 * s   运输公司也要求司机用最少的天数将货物交付。
 *
 * sr: 输入包含多个测试用例。每个测试用例的第一行是一个整数n=[2,10000]，表示在规划路线时要考虑的城市数。
 * s   城市的编号从1到 n, 其中1是起始城市, n 是目的地城市。
 * s   下一行包含一个整数 h=[0,min(n,100)]，后跟数字 c1,c2,...,ch。表示连锁酒店所在城市的编号。
 * s   第三行包含一个整数 m=[1,105]，为规划路线考虑的路的数量。接下来的m行描述路。
 * s   每条路包含3个整数 a=[1,n]、b=[1,n]、t=[1,600]，其中 a、b 是路连接的两个城市。
 * s   t是在这条路上行驶所需的时间。输入n=0时终止。
 *
 * sc: 对于每个测试用例，输出一行包含运输公司将货从城市1送到城市n而必须为司机预定入住的最少的酒店数量。
 * s   如果不可能找到路线使得驾驶员每天最多行驶10小时 ，则输出-1。
 *
 * ei: 6
 *     3 2 5 3
 *     8
 *     1 2 400
 *     3 2 80
 *     3 4 301
 *     4 5 290
 *     5 6 139
 *     1 3 375
 *     2 5 462
 *     4 6 300
 *     3
 *     0
 *     2
 *     1 2 371
 *     2 3 230
 *     0
 *
 * eo: 2
 *     -1
 *
 * sl:
 */

public class Main042
{
 static boolean debug = true;

 static class City
 {
  boolean hasHotel = false;
  LinkedList<Road> roadList = new LinkedList<>();
 }

 static class Road
 {
  City c1, c2;
  int time;//此路所需行驶时间
 }

 static class Node
 {
  City city;
  int spendTime;

  public Node(City city, int time)
  {
   this.city = city;
   spendTime = time;
  }
 }

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  int n;// 城市数、目的城市
  City city[];
  Road road[];
  int minHotelCount = -1;

  LinkedList<Node> OPEN = new LinkedList<>(), CLOSED = new LinkedList<>();
  Node currentNode;

  while (true)
  {
   n = scr.nextInt();
   if (n == 0) break;

   city = new City[n];
   for (int i = 0; i < city.length; i++)
   {
    city[i] = new City();
   }
   for (int i = scr.nextInt(); i > 0; i--)
   {
    city[scr.nextInt() - 1].hasHotel = true;
   }
   road = new Road[scr.nextInt()];
   for (int i = 0; i < road.length; i++)
   {
    road[i] = new Road();
    road[i].c1 = city[scr.nextInt() - 1];
    road[i].c2 = city[scr.nextInt() - 1];
    road[i].time = scr.nextInt();
   }

   int usedTime = 0, hotelCount = 0;
   OPEN.add(new Node(city[0], 0));
   while (!OPEN.isEmpty())
   {
    currentNode = OPEN.removeLast();
    usedTime += currentNode.spendTime;

    if (usedTime > 600)
    {
     if (currentNode.city.hasHotel)
     {
      usedTime = 0;
      hotelCount++;
     }else
     {
      usedTime -= currentNode.spendTime;
      continue;
     }
    }
    if (currentNode.city == city[n - 1])
    {
     if (minHotelCount < 0 || minHotelCount > hotelCount) minHotelCount = hotelCount;
     hotelCount = 0;
     continue;
    }else
    {
     if (usedTime == 600)
     {
      if (currentNode.city.hasHotel)
      {
       usedTime = 0;
       hotelCount++;
      }
     }else
     {
      continue;
     }
    }

    City nextCity;
    for (Road r : currentNode.city.roadList)
    {
     if (r.c1 == currentNode.city) nextCity = r.c2;
     else nextCity = r.c1;
     if (usedTime + r.time <= 600 || nextCity.hasHotel) OPEN.add(new Node(nextCity, r.time));
    }

   }

   System.out.println(minHotelCount);

  }

  scr.close();
 }

 // static void expandNode(City city, LinkedList<Node> open, LinkedList<Node> closed)
 // {
 // }

 // static Node getNextBestNode(LinkedList<Node> list)
 // {
 //  for (Node node : list)
 //  {
 //
 //  }
 //  return null;
 // }

 static void logPrintln(Object o)
 {
  if (debug) System.out.println(o);
 }

}
