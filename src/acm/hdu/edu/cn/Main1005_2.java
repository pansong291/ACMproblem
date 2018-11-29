package acm.hdu.edu.cn;

import java.util.Scanner;

/*
title:


description:


input:


output:


sample input:


sample output:


hint:
使用矩阵快速幂算法，并且每次矩阵相乘时，结果都余以7
 */

public class Main1005_2
{
 static boolean debug = true;

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  int A, B, n;
  Matrix pow = new Matrix(2, 2), base = new Matrix(2, 1), res;
  base.m[0][0] = 1;
  base.m[1][0] = 1;

  while (true)
  {
   A = scr.nextInt();
   B = scr.nextInt();
   n = scr.nextInt();
   if (A == 0 && B == 0 && n == 0) break;

   if (n < 3)
   {
    System.out.println(1);
    continue;
   }
   pow.m[0][0] = A % 7;
   pow.m[0][1] = B % 7;
   pow.m[1][0] = 1;
   pow.m[1][1] = 0;
   pow = pow.quickPow(n - 2);
   res = pow.multiply(base);
   System.out.println(res.m[0][0]);
  }

  scr.close();
 }

 static class Matrix
 {
  int m[][];

  public Matrix(int x, int y)
  {
   m = new int[x][y];
  }

  Matrix multiply(Matrix matrix)
  {
   Matrix res = new Matrix(m.length, matrix.m[0].length);
   int t = 0;
   for (int i = 0; i < m.length; i++)
   {
    for (int j = 0; j < matrix.m[0].length; j++)
    {
     for (int k = 0; k < matrix.m.length; k++)
     {
      t += m[i][k] * matrix.m[k][j];
     }
     res.m[i][j] = t % 7;
     t = 0;
    }
   }
   return res;
  }

  Matrix quickPow(int n)
  {
   Matrix ans = new Matrix(m.length, m[0].length);
   for (int i = 0; i < ans.m.length; i++)
   {
    for (int j = 0; j < ans.m[0].length; j++)
    {
     if (i == j) ans.m[i][j] = 1;
     else ans.m[i][j] = 0;
    }
   }
   Matrix x = this;

   while (n > 0)
   {
    if ((n & 1) != 0) ans = ans.multiply(x);
    x = x.multiply(x);
    n >>>= 1;
   }
   return ans;
  }

 }

 static void logPrintln(Object o)
 {
  if (debug) System.out.println(o);
 }

}
