package sicauoj;

import java.util.Scanner;

/*
title:
罗家银行            --finish

description:
为了让客户取钱很麻烦，罗家银行每次只允许客户提取下列数额的钱：
1 ￥
6￥, 6^2￥, 6^3￥, ...
9￥, 9^2￥, 9^3￥, ...
现在有个问题是你在罗家银行取 N 块钱，最少需要取几次？
当然你不能再存入之前取出来的钱

input:
1≤N≤100000，N为整数

output:
输出次数

sample input:
127

sample output:
4

sample input 2:
3

sample output 2:
3

sample input 3:
44852

sample output 3:
16

hint:
动态规划，从小往大推理，两个数组分开
比如16吧，可以选9或6，16-9=7，16-6=10，接下来看7和10的最小次数
7和10的最小和16就没关系了，满足dp的
一次次减才可以，不能直接除
 */

public class Main009
{
 static boolean debug = true;
 static final Scanner scr = new Scanner(System.in);
 static int six6[] = new int[]{6, 36, 216, 1296, 7776, 46656};
 static int nine5[] = new int[]{9, 81, 729, 6561, 59049};
 // static int base[] = new int[]{1, 6, 9, 36, 81, 216, 729, 1296, 6561, 7776, 46656, 59049};
 // static int count;

 public static void main(String[] args)
 {
  int n = scr.nextInt();
  //  count = 0;
  /*for (int i = base.length, t; i > 0; i--)
  {
   t = dg(n, i, 0);
   if (count < 1 || count > t) count = t;
  }*/
  //  while (true)
  System.out.println(dg(n));

  scr.close();
 }

 static int dg(int n)
 {
  int nine = binSearch(n, nine5), six = binSearch(n, six6);
  if (six == 1) return n;
  if (nine == 1) return n - 5;
  if (n == nine || n == six) return 1;
  return Math.min(dg(n - nine), dg(n - six)) + 1;
 }

 static int binSearch(int num, int[] seq)
 {
  int left = 0, right = seq.length, mid = right / 2;
  if (num < seq[left]) return 1;
  if (num > seq[right - 1]) return seq[right - 1];
  for (;;)
  {
   if (num < seq[mid])
   {
    right = mid;
   }else if (num > seq[mid])
   {
    if (left == mid) break;
    left = mid;
   }else
   {
    break;
   }
   mid = (left + right) / 2;
  }
  return seq[mid];
 }

 static void logPrintln(Object o)
 {
  if (debug) System.out.println(o);
 }

}
