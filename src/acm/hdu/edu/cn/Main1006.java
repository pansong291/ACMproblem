package acm.hdu.edu.cn;

import java.util.Scanner;

/*
title:
Tick and Tick

description:


input:


output:


sample input:


sample output:


hint:
 */

public class Main1006
{
 static boolean debug = true;

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  double D;
  double mPos, hPos, sPos;
  int happyCount;
  while (true)
  {
   //   for(int m=0;m<60;m++)
   //    for(int s=0;s<60;s++)
   //     System.out.println("hp="+getHourPos(0,getMinPos(m,s))+",mp="+getMinPos(m,s)+"sp="+s*6);
   D = scr.nextDouble();
   if (D < 0) break;
   happyCount = 0;
   for (int s = 0; s < 43200; s++)
   {
    mPos = s / 10d;
    mPos %= 360;
    hPos = s / 120d;
    sPos = s * 6 % 360;
    if (abs(mPos, sPos) < D) continue;
    if (abs(hPos, mPos) < D) continue;
    if (abs(hPos, sPos) < D) continue;
    happyCount++;
   }
   System.out.println(happyCount);
   System.out.printf("%.3f\n", (happyCount) / (12d * 36));
   happyCount = 0;
   for (int h = 0; h < 12; h++)
   {
    for (int m = 0; m < 60; m++)
    {
     for (int s = 0; s < 60; s++)
     {
      //System.out.println(h+":"+m+":"+s);
      mPos = getMinPos(m, s);
      if (abs(mPos, s * 6) < D)
      {
       //System.out.println(h+":"+m+":"+s+",m,s");
       continue;
      }
      hPos = getHourPos(h, mPos);
      //System.out.println("hp="+hPos+",mp="+mPos+",sp="+s*6);
      if (abs(hPos, mPos) < D)
      {
       //System.out.println(h+":"+m+":"+s+",h,m");
       continue;// form;
      }
      if (abs(hPos, s * 6) < D)
      {
       //System.out.println(h+":"+m+":"+s+",h,s");
       continue;
      }
      //if(!happy)
      //{
      //System.out.println(h+":"+m+":"+s);
      happyCount++;
      //}
     }
    }
   }
   System.out.println(happyCount); // 90 6.251
   System.out.printf("%.3f\n", (happyCount) / (12d * 36));
  }

  scr.close();
 }

 static double getHourPos(int h, double ms)
 {
  /*
    1h1m30s
    1h1.5m
    30+1.5/12rad
    =(h+m/60)*30
    =(h+mp/6/60)*30
    =h*30+mp/12
  */
  //  if (h >= 12) h -= 12;
  ms = h * 30 + ms / 12;
  //ms = h*30;
  return ms;
 }

 static double getMinPos(int m, int s)
 {
  /*
    1m30s
    1.5m
    6+3rad
    =m*6+s/10
    =(m+s/60)*6
  */
  return m * 6 + s / 10d;
 }

 static double abs(double d1, double d2)
 {
  double diff;
  if (d1 > d2) diff = d1 - d2;
  else diff = d2 - d1;
  if (diff > 180) diff = 360d - diff;
  return diff;
 }

 static void logPrintln(Object o)
 {
  if (debug) System.out.println(o);
 }

}
