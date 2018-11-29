package acm.hdu.edu.cn;

import java.util.LinkedList;
import java.util.Scanner;

/*
title:
Let the Balloon Rise            --finish

description:
Contest time again! How excited it is to see balloons floating around.
But to tell you a secret, the judges' favorite time is guessing the most popular problem.
When the contest is over, they will count the balloons of each color and find the result.
This year, they decide to leave this lovely job to you.

input:
Input contains multiple test cases.
Each test case starts with a number N (0 < N <= 1000) -- the total number of balloons distributed.
The next N lines contain one color each. The color of a balloon is a string of up to 15 lower-case letters.
A test case with N = 0 terminates the input and this test case is not to be processed.


output:
For each case, print the color of balloon for the most popular problem on a single line.
It is guaranteed that there is a unique solution for each test case.

sample input:
5
green
red
blue
red
red
3
pink
orange
pink
0

sample output:
red
pink

hint:

 */

public class Main1004
{
 static boolean debug = true;

 static class Balloon
 {
  String color = null;
  int count = 0;

  public Balloon(String s)
  {
   color = s;
   count = 1;
  }
 }

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  int inputEnd;
  LinkedList<Balloon> list = new LinkedList<>();
  String color;
  Balloon popular = null;

  while (true)
  {
   inputEnd = scr.nextInt();
   if (inputEnd == 0) break;
   scr.nextLine();
   for (int i = 0; i < inputEnd; i++)
   {
    color = scr.nextLine();
    if (list.isEmpty()) list.add(new Balloon(color));
    else for (Balloon balloon : list)
    {
     if (color.equals(balloon.color))
     {
      balloon.count++;
      break;
     }else if (list.getLast() == balloon)
     {
      popular = new Balloon(color);
     }
    }
    if (popular != null)
    {
     list.add(popular);
     popular = null;
    }
   }
   for (Balloon balloon : list)
   {
    if (popular == null || popular.count < balloon.count) popular = balloon;
   }
   System.out.println(popular.color);
   popular = null;
   list.clear();
  }

  scr.close();
 }

 static void logPrintln(Object o)
 {
  if (debug) System.out.println(o);
 }

}
