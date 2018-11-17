package sicauoj;

import java.util.Scanner;

/*
 * tm: 打工送货
 * 
 * ms: 运输公司规定每个司机每天最多只能工作10小时，然后在指定的一家签定了免费入住协议的连锁酒店休息一晚。
 * s   运输公司也要求司机用最少的天数将货物交付。
 * 
 * sr: 输入包含多个测试用例。每个测试用例的第一行是一个整数n=[2,10000]，表示在规划路线时要考虑的城市数。
 * s   城市的编号从1到 n, 其中1是起始城市, n 是目的地城市。
 * s   下一行包含一个整数 h=[0,min(n,100)]，后跟数字 c1,c2,...,ch。表示连锁酒店所在城市的编号。
 * s   第三行包含一个整数 m=[1,105]，为规划路线考虑的路的数量。接下来的m行描述路。
 * s   每条路包含3个整数 a=[1,n]、b=[1,n]、t=[1,600]，其中 a、b 是路连接的两个城市。
 * s   t是在这条路上行驶所需的时间。输入n=0时终止。
 * 
 * sc: 对于每个测试用例，输出一行包含运输公司将货从城市1送到城市n而必须为司机预定入住的最少的酒店数量。
 * s   如果不可能找到路线使得驾驶员每天最多行驶10小时 ，则输出-1。
 * 
 * ei: 6
 *     3 2 5 3
 *     8
 *     1 2 400
 *     3 2 80
 *     3 4 301
 *     4 5 290
 *     5 6 139
 *     1 3 375
 *     2 5 462
 *     4 6 300
 *     3
 *     0
 *     2
 *     1 2 371
 *     2 3 230
 *     0
 * 
 * eo: 2
 *     -1
 * 
 * sl: 
 */

public class P042
{

 static class Test
 {
  boolean debug = true;

  public Test(Scanner scr)
  {
  }

  public void run()
  {
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
  scr.nextLine();
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
