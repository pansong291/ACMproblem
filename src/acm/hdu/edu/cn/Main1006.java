package acm.hdu.edu.cn;

import java.util.Scanner;

/*
tm:

ms:

sr:

sc:

ei:

eo:

sl:
 */

public class Main1006
{
 static boolean debug = true;

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  float D;

  while (true)
  {
   D = scr.nextFloat();
   if (D < 0) break;

  }

  scr.close();
 }

 static float getHourPos(int h, float ms)
 {
  if (h >= 12) h -= 12;
  return h + ms;
 }

 static float getMinPos(int m, int s)
 {
  return m + s / 60f;
 }

 static float getAngle(float f1, float f2)
 {
  return Math.abs(f1 - f2) / 60f;
 }

 static void logPrintln(Object o)
 {
  if (debug) System.out.println(o);
 }

}
