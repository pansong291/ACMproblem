package acm.hdu.edu.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
title:
FatMouse' Trade         --finish

description:
FatMouse prepared M pounds of cat food, ready to trade with the cats guarding
the warehouse containing his favorite food, JavaBean.
The warehouse has N rooms. The i-th room contains J[i] pounds of JavaBeans and
requires F[i] pounds of cat food. FatMouse does not have to trade for all the
JavaBeans in the room, instead, he may get J[i]* a% pounds of JavaBeans if he
pays F[i]* a% pounds of cat food. Here a is a real number. Now he is assigning
this homework to you: tell him the maximum amount of JavaBeans he can obtain.

input:
The input consists of multiple test cases. Each test case begins with a line
containing two non-negative integers M and N. Then N lines follow, each contains
two non-negative integers J[i] and F[i] respectively. The last test case is
followed by two -1's. All integers are not greater than 1000.

output:
For each test case, print in a single line a real number accurate up to 3 decimal
places, which is the maximum amount of JavaBeans that FatMouse can obtain.

sample input:
5 3
7 2
4 3
5 2
20 3
25 18
24 15
15 10
-1 -1

sample output:
13.333
31.500

hint:

 */

public class Main1009
{
 static class Room
 {
  int J, F;
  double price;
 }

 static class MyComparator implements Comparator<Room>
 {
  @Override
  public int compare(Room o1, Room o2)
  {
   if (o1.price > o2.price) return -1;
   else if (o1.price < o2.price) return 1;
   else if (o1.F > o2.F) return -1;
   else if (o1.F < o2.F) return 1;
   else if (o1.J > o2.J) return -1;
   else if (o1.J < o2.J) return 1;
   return 0;
  }
 }

 static final MyComparator myComparator = new MyComparator();

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  int M, N;
  Room rooms[];
  double sum;
  while (true)
  {
   M = scr.nextInt();
   N = scr.nextInt();
   if (M == -1 && N == -1) break;
   rooms = new Room[N];
   sum = 0;
   for (int i = 0; i < N; i++)
   {
    rooms[i] = new Room();
    rooms[i].J = scr.nextInt();
    rooms[i].F = scr.nextInt();
    rooms[i].price = ((double) rooms[i].J) / rooms[i].F;
   }
   Arrays.sort(rooms, myComparator);
   for (int i = 0; i < N; i++)
   {
    //System.out.println(rooms[i].price);
    if (M < rooms[i].F)
    {
     sum += M * rooms[i].price;
     break;
    }
    M -= rooms[i].F;
    sum += rooms[i].J;
   }
   System.out.printf("%.3f\r\n", sum);
  }
 }
}
