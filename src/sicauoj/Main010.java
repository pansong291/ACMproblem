package sicauoj;

import java.util.Scanner;

/*
tm:
数字组合            --finish

ms:
在N个数中找出其和为M的若干个数。
先读入正整数N和M，再读入N个正数（可以有相同的数字，每个数字均在1000以内），
在这N个数中找出若干个数，使它们的和是M，把满足条件的数字组合都找出来以统计组合的个数，
输出组合的个数（不考虑组合是否相同）。

sr:
第一行是两个数字，表示N和M。(0<N<100, 0<M<10000)。第二行起是N个数。

sc:
一个数字，表示和为M的组合的个数。

ei:
4 4
1 1 2 2

eo:
3

sl:
对于每一个正数，都有加与不加两种选择，故共有 2^N 种情况，可以遍历二叉树求解。
N 较小时可以用递归进行深度搜索
 */

public class Main010
{
 static boolean debug = true;

 static int k[], m, count;

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  k = new int[scr.nextInt()];
  m = scr.nextInt();
  count = 0;
  //  int sum = 0;
  for (int i = 0; i < k.length; i++)
  {
   k[i] = scr.nextInt();
  }

  dfs(0, 0);
  System.out.println(count);

  scr.close();
 }

 static void dfs(int i, int sum)
 {
  if (sum == m) count++;
  // ps：如果没有下面这个 sum>=m 的判断就会超时
  if (sum >= m || i == k.length) return;
  dfs(i + 1, sum);
  dfs(i + 1, sum + k[i]);
 }

 static void logPrintln(Object o)
 {
  if (debug) System.out.println(o);
 }

}
