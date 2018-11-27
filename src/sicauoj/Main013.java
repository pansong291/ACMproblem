package sicauoj;

import java.util.Scanner;

/*
tm:
质数检测            --finish

ms:
给出N个正整数，检测每个数是否为质数。如果是，输出"Yes"，否则输出"No"。

sr:
第1行：一个数N，表示正整数的数量。(1≤N≤1000)
第2到N+1行：每行1个数 a(2≤a≤10^9)

sc:
输出共N行，每行为 Yes 或 No。

ei:
5
2
3
4
5
6

eo:
Yes
Yes
No
Yes
No

sl:
 */

public class Main013
{
 static boolean debug = true;

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  int testCount = scr.nextInt();
  //  scr.nextLine();
  int num;
  double sqrt;

  while1: while (testCount-- > 0)
  {
   num = scr.nextInt();

   sqrt = Math.sqrt(num);
   //System.out.println(zhishuCount + 1);
   //    if (i < 4) System.out.println("Yes");
   for (int j = 2; j <= sqrt; j++)
   {
    if (num % j == 0)
    {
     //System.out.println(num + "%" + j + "=0");
     System.out.println("No");
     continue while1;
    }
   }
   //   if (zhishu[zhishuCount - 1] == num)
   //   {
   //    System.out.println("Yes");
   //   }else
   //   {
   //    System.out.println("No");
   //   }
   System.out.println("Yes");
  }

  scr.close();
 }

 static void logPrintln(Object o)
 {
  if (debug) System.out.println(o);
 }

}
