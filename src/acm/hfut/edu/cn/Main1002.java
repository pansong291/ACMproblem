package acm.hfut.edu.cn;

import java.util.Scanner;

/*
tm:
A-斯坦恩布莱德防御战         --finish

ms:
豺狼人带着小提米从(0,0)处开始沿着路径y=kx以速度v逃逸，阿尔萨斯的部队位于(a,b)，那么为了使得追击距离最短并且能正好追上豺狼人，阿尔萨斯的部队应该采取怎样的速率呢？

sr:
输入包括多行数据，每行数据有四个数k,a,b,v，输入以文件结尾结束。注意，0<k,a,b,v<1000。

sc:
每行输出一个数，表示阿尔萨斯的部队的速度。如果不存在这样的速度，输出一行Impossible。输出的数保留三位小数。

ei:
1 1 1 1
2 2 2 2

eo:
0.000
0.667

sl:
 */
/*
#include<stdio.h>
#include<math.h>
main(){double k,a,b,v;for(;~scanf("%lf%lf%lf%lf",&k,&a,&b,&v);printf("%.3lf\n",v)){k=(a+k*b)/sqrt(k*k+1)/v;v=sqrt((a*a+b*b)/k/k-v*v);}}
*/
public class Main1002
{
 static boolean debug = true;

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  double k, v, a, b, v2, t;

  while (scr.hasNextDouble())
  {
   k = scr.nextDouble();
   a = scr.nextDouble();
   b = scr.nextDouble();
   v = scr.nextDouble();

   // ps: 计算赶上的时间
   t = (a + k * b) / Math.sqrt(k * k + 1) / v;
   // ps: 计算需要的速度
   v2 = Math.sqrt((a * a + b * b) / t / t - v * v);

   System.out.printf("%.3f\n", v2);
  }

  scr.close();
 }

 static void logPrintln(Object o)
 {
  if (debug) System.out.println(o);
 }

}
