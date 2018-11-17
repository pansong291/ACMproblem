package sicauoj;

import java.util.Scanner;

/*
 * tm: 矩形相交     --finish
 * 
 * ms: 
 * 
 * sr: 
 * 
 * sc: 
 * 
 * ei: 
 * 
 * eo: 
 * 
 * sl: 判断矩形在坐标轴上的投影是否相交。
 */

public class P036_2
{

 static class Rect
 {
  float minX, minY, maxX, maxY;

  public Rect(float f1x, float f1y, float f2x, float f2y)
  {
   minX = f1x;
   minY = f1y;
   maxX = f1x;
   maxY = f1y;
   if (minX > f2x) minX = f2x;
   else if (maxX < f2x) maxX = f2x;
   if (minY > f2y) minY = f2y;
   else if (maxY < f2y) maxY = f2y;
  }

  boolean isInside(Rect r)
  {
   return minX > r.minX && maxX < r.maxX && minY > r.minY && maxY < r.maxY;
  }

  boolean isCross(Rect r)
  {
   // x轴上的投影是否相交
   if (r.minX > maxX || r.maxX < minX) return false;
   // y轴上的投影是否相交
   if (r.minY > maxY || r.maxY < minY) return false;
   // ps: 排除包含
   if (isInside(r)) return false;
   if (r.isInside(this)) return false;
   return true;
  }
 }

 static class Test
 {
  static boolean debug = false;
  float f[] = new float[8];
  Rect r1, r2;

  public Test(Scanner scr)
  {
   for (int i = 0; i < f.length; i++)
   {
    f[i] = scr.nextFloat();
   }
   r1 = new Rect(f[0], f[1], f[2], f[3]);
   r2 = new Rect(f[4], f[5], f[6], f[7]);
  }

  public void run()
  {
   if (r1.isCross(r2)) System.out.println("Yes");
   else System.out.println("No");
  }

  void println(Object o)
  {
   if (debug) System.out.println(o);
  }

 }

 static Test test[];

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  test = new Test[scr.nextInt()];
  for (int i = 0; i < test.length; i++)
  {
   test[i] = new Test(scr);
  }
  for (int i = 0; i < test.length; i++)
  {
   test[i].run();
  }
 }

}
