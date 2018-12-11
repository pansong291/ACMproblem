package sicauoj;

import java.util.Scanner;

/*
title:


description:


input:


output:


sample input:


sample output:


hint:

 */

public class Main014
{
 static boolean debug = true;
 static final Scanner scr = new Scanner(System.in);

 public static void main(String[] args)
 {
  int n = scr.nextInt();
  Road m[] = new Road[scr.nextInt()];
  for (int i = 0; i < m.length; i++)
  {
   m[i] = new Road();
   m[i].p1 = scr.nextInt();
   m[i].p2 = scr.nextInt();
  }


  scr.close();
 }

 static class Node
 {
  int p;

 }

 static class Road
 {
  int p1, p2;
  boolean isRrelationship;
 }

 static void logPrintln(Object o)
 {
  if (debug) System.out.println(o);
 }

}
