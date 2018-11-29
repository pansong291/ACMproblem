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

public class Main033_2
{
 static boolean debug = true;

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  int r, w, l, n = 0;

  while (true)
  {
   r = scr.nextInt();
   if (r == 0) break;
   w = scr.nextInt();
   l = scr.nextInt();

   n++;
   if (2 * r >= Math.sqrt(Math.pow(w, 2) + Math.pow(l, 2))) System.out.println("cake " + n + " fits");
   else System.out.println("cake " + n + " does not fit");
  }

  scr.close();
 }

 static void logPrintln(Object o)
 {
  if (debug) System.out.println(o);
 }

}
