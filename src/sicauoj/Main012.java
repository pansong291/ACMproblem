package sicauoj;

import java.util.Scanner;

/*
title:
数塔取数            --finish

description:
一个高度为N的由正整数组成的三角形，从上走到下，求经过的数字和的最大值。
每次只能走到下一层相邻的数上，例如从第3层的6向下走，只能走到第4层的2或9上。
   5
  8 4
 3 6 9
7 2 9 5

input:
第1行：N，N为数塔的高度。(2 <= N <= 500)
第2 - N + 1行：每行包括1层数塔的数字，第2行1个数，第3行2个数......第k+1行k个数。
数与数之间用空格分隔（0 <= A[i] <= 10^5) 。

output:
输出最大值

sample input:
4
5
8 4
3 6 9
7 2 9 5

sample output:
28

hint:
动态规划，自底向上的思路
 */

public class Main012
{
 static boolean debug = true;
 static final Scanner scr = new Scanner(System.in);

 public static void main(String[] args)
 {
  int tower[][] = new int[scr.nextInt()][];
  int dp[] = new int[tower.length];
  for (int i = 0; i < tower.length; i++)
  {
   tower[i] = new int[i + 1];
   for (int j = 0; j < i + 1; j++)
   {
    tower[i][j] = scr.nextInt();
    if (i == tower.length - 1) dp[j] = tower[i][j];
   }
  }
  for (int i = tower.length - 2; i >= 0; i--)
  {
   for (int j = 0; j < tower[i].length; j++)
   {
    dp[j] = Math.max(dp[j], dp[j + 1]) + tower[i][j];
   }
  }
  System.out.println(dp[0]);

  scr.close();
 }

 static void logPrintln(Object o)
 {
  if (debug) System.out.println(o);
 }

}
