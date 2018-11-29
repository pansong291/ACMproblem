package sicauoj;

/*
title:
出圈问题

description:
M个人围成一圈报数，数到N（1 < N < 10）的倍数或包含N这个数字时出圈，问剩下的最后一个人在原来的位置是多少？ 报数规则：
 1、从第一个人开始报数为1，下一个人报数为上一个人报数加1
 2、报数的最大值为2000，如果报数超过2000，则下一个人重新从1开始报数

input:
iTotalNum： 开始报数前的总人数, 0 < iTotalNum < 65535
iKey：题目中要求的数目N

output:
剩下的人的原来的位置

sample input:
5 3

sample output:
4

sample input 2:
15 3

sample output 2:
10

hint:
 */

import java.util.Scanner;

public class Main020
{
 static class Node
 {
  int num;
  Node next;
 }

 static boolean debug = true;

 public static void main1(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  int iTotalNum = scr.nextInt(), iKey = scr.nextInt();
  Node first = null, current = null, theNext, theLast = null;
  int count = 0;

  for (int i = 0; i < iTotalNum; i++)
  {
   theNext = new Node();
   theNext.num = i + 1;
   logPrint(theNext.num + " ");
   if (i == 0)
   {
    first = theNext;
    current = first;
   }else
   {
    current.next = theNext;
    current = theNext;
   }
  }
  logPrintln("");

  current.next = first;//构成循环链

  do
  {
   while (true)//报数
   {
    theLast = current;
    current = current.next;
    count++;
    if (count > 2000) count = 1;
    if (count % iKey == 0)
    {
     break;
    }
   }

   logPrintln("out:" + current.num);
   theLast.next = current.next;
   current = theLast;
  }while (current.next != current);

  System.out.println(current.num);

  //  current = first;
  //  while (current != null)
  //  {
  //   System.out.print(current.num + " ");
  //   current = current.next;
  //  }

  scr.close();
 }

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  int iTotalNum = scr.nextInt(), iKey = scr.nextInt();
  scr.close();
  int[] person = new int[iTotalNum];
  int outedCount = 0; // 已出局的人数
  int count = 0; // 报数
  int pi = -1; // 人数循环
  for (int i = 0; i < person.length; i++)
  {
   person[i] = i + 1;
   logPrint(person[i] + " ");
  }
  logPrintln("");

  while (outedCount < person.length - 1)
  {
   count++;
   if (count > 2000) count = 1;
   do
   {
    pi++;
    if (pi >= person.length) pi = 0;
   }while (person[pi] < 0);
   if (count % iKey == 0)
   {
    logPrintln("out:" + person[pi]);
    person[pi] = -1; // 出局
    outedCount++;
   }
  }

  for (int i = 0; i < person.length; i++)
  {
   if (person[i] > 0)
   {
    System.out.println(person[i]);
    break;
   }
  }
 }

 static void logPrint(Object o)
 {
  if (debug) System.out.print(o);
 }

 static void logPrintln(Object o)
 {
  if (debug) System.out.println(o);
 }

}
