package sicauoj;

import java.util.Arrays;
import java.util.Scanner;

/*
tm:
小明小红            --finish

ms:
小明有 n 个苹果，每个苹果都有一个正整数代表其重量。
现在小明想把苹果分一些给小红，使得小红和小明各自所有的苹果总重差值最小。
例如：1 2 3 4 5，将1 2 4分为1组，3 5分为1组，两组和相差1，是所有方案中相差最少的。

sr:
第1行：一个数N，N为苹果的数量。
第2至N+1行，N个正整数代表苹果重量。(N≤100, 所有正整数的和 ≤10000)

sc:
输出这个最小的差值

ei:
5
1
2
3
4
5

eo:
1

sl:
倒序贪婪
先按照从大到小的顺序对苹果排序，然后
如果要求每个人分配到的苹果数量也很平均，就正序地把第i到i+c-1个苹果分配给c个人，然后将这c个人按照苹果重量从小到大排序，重复下一次分配
如果不要求分配到的苹果数量平均的话，就直接把第i个苹果分配给苹果重量最小的那个人，重复下一次分配
 */

public class Main007
{

 static int apples[];

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  apples = new int[scr.nextInt()];
  for (int i = 0; i < apples.length; i++)
  {
   apples[i] = scr.nextInt();
  }
  scr.close();

  Arrays.sort(apples);
  int ap1 = 0, ap2 = 0;
  for (int i = apples.length - 1; i >= 0; i--)
  {
   if (ap1 < ap2)
   {
    ap1 += apples[i];
   }else
   {
    ap2 += apples[i];
   }
  }

  System.out.println(Math.abs(ap1 - ap2));
 }
}
