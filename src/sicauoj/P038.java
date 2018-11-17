package sicauoj;

import java.util.LinkedList;
import java.util.Scanner;

/*
 * tm: 校园内的路灯
 * 
 * ms: 每条路一到天黑就开灯，一开就是一整夜，而电费按道路每米一天要花费1块钱。为了省钱要关掉一些街道的路灯。
 * m   为了确保教师和学生仍然感到安全，在夜晚一些街道变暗之后，在学校的每一个路口，
 * m   仍然会有至少一条照明的路径到其它任何一个路口。在不让川牛们感到不安全的情况下，学校可以节省的最大每日金额是多少?
 * 
 * sr: 输入包含若干测试用例。每个测试用例分别以两个数字m=[1,200000]和n=[m-1,200000]开始，
 * s   分别是学校内路口的数量和道路数量，当m=n=0时终止。接下来有n个整数三元组x=[0,m),y=[0,m),z
 * s   指定路口x和路口y之间有一条长度为z米的双向道路，且x!=y。
 * s   每个测试用例保证了任意两个路口之间一定有一条可达的路线。每个测试用例中所有道路的总长度小于231231。
 * 
 * sc: 每一个测试案例需要输出一行，表示学校每日可以节约的最高金额。
 * 
 * ei: 7 11
 *     0 1 7
 *     0 3 5
 *     1 2 8
 *     1 3 9
 *     1 4 7
 *     2 4 5
 *     3 4 15
 *     3 5 6
 *     4 5 8
 *     4 6 9
 *     5 6 11
 *     0 0
 * 
 * eo: 51
 * 
 * sl: 
 */

public class P038
{

 static class Test
 {
  static boolean debug = true;
  static boolean inputEnd = false;

  public Test(Scanner scr)
  {
   if (scr.nextInt() == 0)
   {
    inputEnd = true;
    return;
   }
  }

  public void run()
  {
  }

  void println(Object o)
  {
   if (debug) System.out.println(o);
  }

 }

 static LinkedList<Test> test;

 public static void main(String[] args)
 {
  Scanner scr = new Scanner(System.in);
  test = new LinkedList<Test>();
  while (true)
  {
   Test t = new Test(scr);
   if (Test.inputEnd) break;
   else test.add(t);
  }
  while (!test.isEmpty())
  {
   test.removeFirst().run();
  }
 }

}
