package sicauoj;

import java.util.Scanner;

/*
 * tm: 矩形相交     --finish
 * 
 * ms: 平面坐标系中有两个与坐标轴平行的矩形，判断他们是否边相交（边重合也算相交）。
 * 
 * sr: 第一行将输入一个整数N=(0,1000]。随后将有N行测试用例，每一行都包含8个实数，分别是X1,Y1,X2,Y2,X3,Y3,X4,Y4。
 *     (X1,Y1)-(X2,Y2)和(X3,Y3)-(X4,Y4)分别是两个矩形的其中一条斜边。
 * 
 * sc: 对于每个测试用例，若果两个矩形的边相交，则输出Yes，否则输出No，各占一行。
 * 
 * ei: 2
 *     1 1 2.2 3 2 2 5 5
 *     0 -1 -2 0 1 1 3 2
 * 
 * eo: Yes
 *     No
 * 
 * sl: 转化为线段相交，再利用向量外积判断。
 */

public class P036_1
{
 static class Point
 {
  float x, y;

  public Point()
  {
  }

  public Point(float px, float py)
  {
   x = px;
   y = py;
  }
 }

 static class Line
 {
  Point p1, p2;

  public Line(Point p1, Point p2)
  {
   if (p2.x > p1.x || p2.y > p1.y)
   {
    this.p1 = p1;
    this.p2 = p2;
   }else
   {
    this.p1 = p2;
    this.p2 = p1;
   }
  }

  boolean isCross(Line l)
  {
   Point vAB, vCD, vAC, vAD, vCA, vCB;
   vAB = getVector(p1, p2);
   vCD = getVector(l.p1, l.p2);
   vAC = getVector(p1, l.p1);
   vAD = getVector(p1, l.p2);
   vCA = getVector(l.p1, p1);
   vCB = getVector(l.p1, p2);
   float i1, i2, i3, i4;
   i1 = outProd(vAB, vAC);
   i2 = outProd(vAB, vAD);
   i3 = outProd(vCD, vCA);
   i4 = outProd(vCD, vCB);
   if (i1 == 0 && i2 == 0) // 共线
   {
    if (l.p1.x > p2.x || l.p2.x < p1.x) return false;
    else if (l.p1.y > p2.y || l.p2.y < p1.y) return false;
   }
   return i1 * i2 <= 0 && i3 * i4 <= 0;
  }

  Point getVector(Point p1, Point p2)
  {
   return new Point(p2.x - p1.x, p2.y - p1.y);
  }

  float outProd(Point v1, Point v2)
  {
   return v1.x * v2.y - v1.y * v2.x;
  }
 }

 static class Rect
 {
  Point p[];
  Line l[];
  float minX, minY, maxX, maxY;

  public Rect(Point p1, Point p2)
  {
   minX = p1.x;
   minY = p1.y;
   maxX = p1.x;
   maxY = p1.y;
   if (minX > p2.x) minX = p2.x;
   else if (maxX < p2.x) maxX = p2.x;
   if (minY > p2.y) minY = p2.y;
   else if (maxY < p2.y) maxY = p2.y;

   p = new Point[4];
   p[0] = new Point(minX, maxY);
   p[1] = new Point(maxX, maxY);
   p[2] = new Point(maxX, minY);
   p[3] = new Point(minX, minY);

   l = new Line[4];
   for (int i = 0; i < l.length; i++)
   {
    if (i == 3) l[i] = new Line(p[i], p[0]);
    else l[i] = new Line(p[i], p[i + 1]);
   }
  }

  boolean isInside(Rect r)
  {
   return minX > r.minX && maxX < r.maxX && minY > r.minY && maxY < r.maxY;
  }

  boolean isCross(Rect r)
  {
   // if (isInside(r)) return true;
   // if (r.isInside(this)) return true;
   for (Line l1 : l)
   {
    for (Line l2 : r.l)
    {
     if (l1.isCross(l2)) return true;
    }
   }
   return false;
  }
 }

 static class Test
 {
  boolean debug = false;
  Point p[];
  Rect r1, r2;

  public Test(Scanner scr)
  {
   p = new Point[4];
   for (int i = 0; i < p.length; i++)
   {
    p[i] = new Point();
    p[i].x = scr.nextFloat();
    p[i].y = scr.nextFloat();
   }
   r1 = new Rect(p[0], p[1]);
   r2 = new Rect(p[2], p[3]);
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
